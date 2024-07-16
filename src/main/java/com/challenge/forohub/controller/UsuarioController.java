package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Usuario;
import com.challenge.forohub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuario_service;

    @GetMapping
    public List<Usuario> getAll(){
        return usuario_service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable("id") Long id){
        return usuario_service.getById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Usuario usuario){
        usuario_service.saveOrUpdate(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        usuario_service.delete(id);
    }

}
