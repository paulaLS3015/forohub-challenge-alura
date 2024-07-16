package com.challenge.forohub.service;

import com.challenge.forohub.entity.LoginDto;
import com.challenge.forohub.entity.Usuario;
import com.challenge.forohub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuario_repository;

    public List<Usuario> getAll(){
        return usuario_repository.findAll();
    }

    public Optional<Usuario> getById(Long id){
        return usuario_repository.findById(id);
    }

    public void saveOrUpdate(Usuario usuario){
        usuario_repository.save(usuario);
    }

    public void delete(Long id){
        usuario_repository.deleteById(id);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(username);

        if(usuario != null) {
            var springUser = User.withUsername(usuario.getNombre())
                    .password(usuario.getContrasena())
                    .roles(usuario.getPerfil())
                    .build();
            return springUser;
        }

        return null;
    }


}
