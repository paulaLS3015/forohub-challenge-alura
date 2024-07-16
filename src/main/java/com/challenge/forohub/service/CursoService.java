package com.challenge.forohub.service;

import com.challenge.forohub.entity.Curso;
import com.challenge.forohub.entity.Topico;
import com.challenge.forohub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository curso_repository;

    public List<Curso> getAll(){
        return curso_repository.findAll();
    }

    public Optional<Curso> getById(Long id){
        return curso_repository.findById(id);
    }

    public void saveOrUpdate(Curso curso){
        curso_repository.save(curso);
    }

    public void delete(Long id){
        curso_repository.deleteById(id);
    }
}
