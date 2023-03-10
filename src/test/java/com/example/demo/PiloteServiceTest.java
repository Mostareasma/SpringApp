package com.example.demo;


import com.example.demo.entity.Pilote;
import com.example.demo.repository.PiloteRepository;
import com.example.demo.service.PiloteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PiloteServiceTest {

    @Autowired
    private PiloteService piloteService;

    private Pilote pilote1;
    private Pilote pilote2;
    private Pilote pilote3;

    @BeforeEach
    void setUp() {
        pilote1 = new Pilote("John Doe", "123 Main St");
        pilote2 = new Pilote("Jane Doe", "456 Main St");
        pilote3 = new Pilote("John Smith", "789 Main St");
    }

    @Test
    public void savePilote() {
        Pilote savedPilote = piloteService.save(pilote1);
        Assertions.assertTrue(savedPilote.equals(pilote1));
    }

    @Test
    public void getAllPilotes() {
        piloteService.save(pilote2);
        List<Pilote> pilotes = piloteService.getAll();
        Assertions.assertTrue(pilotes.contains(pilote2));
    }

    @Test
    public void getPiloteById() {
        Pilote savedPilote = piloteService.save(pilote3);
        Optional<Pilote> pilote = piloteService.getById(savedPilote.getNp());
        Assertions.assertTrue(pilote.isPresent());
        Assertions.assertEquals(savedPilote, pilote.get());
    }

    @Test
    public void updatePilote() {
        Pilote savedPilote = piloteService.save(pilote1);
        savedPilote.setNom("John Wick");
        piloteService.update(savedPilote);
        Optional<Pilote> updatedPilote = piloteService.getById(savedPilote.getNp());
        Assertions.assertTrue(updatedPilote.isPresent());
        Assertions.assertEquals("John Wick", updatedPilote.get().getNom());
    }

    @Test
    public void deletePiloteById() {
        Pilote savedPilote = piloteService.save(pilote2);
        piloteService.deleteById(savedPilote.getNp());
        Optional<Pilote> deletedPilote = piloteService.getById(savedPilote.getNp());
        Assertions.assertFalse(deletedPilote.isPresent());
    }
}
