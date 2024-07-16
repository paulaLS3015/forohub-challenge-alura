package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Curso;
import com.challenge.forohub.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "cursos")
public class CursoController {
    @Autowired
    private CursoService curso_service;

    @GetMapping
    public List<Curso> getAll(){
        return curso_service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getById(@PathVariable("id") Long id){
        return curso_service.getById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Curso curso){
        curso_service.saveOrUpdate(curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        curso_service.delete(id);
    }

}
