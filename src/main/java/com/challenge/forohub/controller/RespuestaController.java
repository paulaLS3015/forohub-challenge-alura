package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Respuesta;
import com.challenge.forohub.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuesta_service;

    @GetMapping
    public List<Respuesta> getAll(){
        return respuesta_service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Respuesta> getById(@PathVariable("id") Long id){
        return respuesta_service.getById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Respuesta curso){
        respuesta_service.saveOrUpdate(curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        respuesta_service.delete(id);
    }

}
