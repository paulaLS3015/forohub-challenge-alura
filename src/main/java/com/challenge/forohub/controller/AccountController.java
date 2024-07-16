package com.challenge.forohub.controller;

import com.challenge.forohub.entity.LoginDto;
import com.challenge.forohub.entity.RegisterDto;
import com.challenge.forohub.entity.Usuario;
import com.challenge.forohub.repository.UsuarioRepository;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Value("${security.jwt.secret-key}")
    private String jwtSecretKey;
    @Value("${security.jwt.issuer}")
    private String jwtIssuer;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Object> register (@Valid @RequestBody RegisterDto registerDto, BindingResult result) {
        if(result.hasErrors()) {
            var errorsList = result.getAllErrors();
            var errorsMap = new HashMap<String, String>();

            for(int i = 0; i < errorsList.size(); i++) {
                var error = (FieldError) errorsList.get(i);
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorsMap);
        }

        var bCryptPasswordEncoder = new BCryptPasswordEncoder();

        var usuario = new Usuario();
        usuario.setNombre(registerDto.getNombre());
        usuario.setCorreo(registerDto.getCorreo());
        usuario.setContrasena(bCryptPasswordEncoder.encode(registerDto.getContrasena()));
        usuario.setPerfil(registerDto.getPerfil());

        try {
            var otherUsuario = usuarioRepository.findByNombre(registerDto.getNombre());
            if(otherUsuario != null) {
                return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso");
            }

            otherUsuario = usuarioRepository.findByCorreo(registerDto.getCorreo());
            if(otherUsuario != null) {
                return ResponseEntity.badRequest().body("El correo ya está en uso");
            }

            usuarioRepository.save(usuario);

            String jwtToken = createJwtToken(usuario);

            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("usuario", usuario);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("Error al registrar el usuario");
    }

    private String createJwtToken(Usuario usuario) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtIssuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(24 * 3600))
                .subject(usuario.getNombre())
                .claim("perfil", usuario.getPerfil())
                .build();

        var encoder = new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecretKey.getBytes()));
        var params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);

        return encoder.encode(params).getTokenValue();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto, BindingResult result) {
        if(result.hasErrors()) {
            var errorsList = result.getAllErrors();
            var errorsMap = new HashMap<String, String>();

            for(int i = 0; i < errorsList.size(); i++) {
                var error = (FieldError) errorsList.get(i);
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorsMap);
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getNombre(), loginDto.getContrasena()));

            var usuario = usuarioRepository.findByNombre(loginDto.getNombre());

            String jwtToken = createJwtToken(usuario);

            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("usuario", usuario);

            return ResponseEntity.ok(response);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("Error al iniciar sesión");
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> profile(Authentication auth) {
        var response = new HashMap<String, Object>();
        response.put("usuario", auth.getName());
        response.put("Authorities", auth.getAuthorities());

        var usuario = usuarioRepository.findByNombre(auth.getName());
        response.put("usuario", usuario);

        return ResponseEntity.ok(response);
    }
}
