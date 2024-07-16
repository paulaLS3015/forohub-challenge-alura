package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Topico;
import com.challenge.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "topicos")
public class TopicoController {
    @Autowired
    private TopicoService topico_service;

    @GetMapping
    public List<Topico> getAll(){
        return topico_service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Topico> getById(@PathVariable("id") Long id){
        return topico_service.getById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Topico topico){
        topico_service.saveOrUpdate(topico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        topico_service.delete(id);
    }

}
