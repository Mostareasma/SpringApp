package com.example.demo.service;

import com.example.demo.entity.Avion;
import com.example.demo.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public List<Avion> getAll() {
        return avionRepository.findAll();
    }

    public Avion getById(Long id) throws Exception {
        return avionRepository.findById(id).orElseThrow(()->new Exception("Doesn't exist"));
    }

    public Avion save(Avion avion) {
        return avionRepository.save(avion);
    }

    public void update(Avion avion) {
        avionRepository.save(avion);
    }

    public void deleteById(Long id) {
        avionRepository.deleteById(id);
    }
}
