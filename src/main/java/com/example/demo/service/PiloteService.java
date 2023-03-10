package com.example.demo.service;

import com.example.demo.entity.Pilote;
import com.example.demo.repository.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiloteService {

    @Autowired
    private PiloteRepository piloteRepository;


    public Pilote save(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    public List<Pilote> getAll() {
        return piloteRepository.findAll();
    }

    public Optional<Pilote> getById(Long id) {
        return piloteRepository.findById(id);
    }

    public Pilote update(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    public void deleteById(Long id) {
        piloteRepository.deleteById(id);
    }
}
