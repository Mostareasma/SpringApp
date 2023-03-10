package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vol;
import com.example.demo.repository.VolRepository;

@Service
public class VolService {

    @Autowired
    private VolRepository volRepository;

    public Vol create(Vol vol) {
        return volRepository.save(vol);
    }

    public Optional<Vol> getById(String id) {
        return volRepository.findById(id);
    }

    public List<Vol> getAll() {
        return volRepository.findAll();
    }

    public void update(String id, Vol vol) {
        volRepository.save(vol);
    }

    public void delete(String id) {
        volRepository.deleteById(id);
    }
}
