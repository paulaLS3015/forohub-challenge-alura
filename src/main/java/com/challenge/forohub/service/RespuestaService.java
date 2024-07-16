package com.challenge.forohub.service;

import com.challenge.forohub.entity.Respuesta;
import com.challenge.forohub.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    RespuestaRepository respuesta_repository;

    public List<Respuesta> getAll(){
        return respuesta_repository.findAll();
    }

    public Optional<Respuesta> getById(Long id){
        return respuesta_repository.findById(id);
    }

    public void saveOrUpdate(Respuesta respuesta){
        respuesta_repository.save(respuesta);
    }

    public void delete(Long id){
        respuesta_repository.deleteById(id);
    }
}
