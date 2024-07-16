package com.challenge.forohub.service;

import com.challenge.forohub.entity.Topico;
import com.challenge.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topico_repository;

    public List<Topico> getAll(){
        return topico_repository.findAll();
    }

    public Optional<Topico> getById(Long id){
        return topico_repository.findById(id);
    }

    public void saveOrUpdate(Topico topico){
        topico_repository.save(topico);
    }

    public void delete(Long id){
        topico_repository.deleteById(id);
    }
}
