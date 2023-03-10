package com.example.demo;

import com.example.demo.entity.Avion;
import com.example.demo.repository.AvionRepository;
import com.example.demo.service.AvionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AvionServiceTest {

    @Autowired
    private AvionService avionService;

    @Autowired
    private AvionRepository avionRepository;

    private Avion avion1;
    private Avion avion2;

    @BeforeEach
    void setUp() {
        avion1 = new Avion("RAM", 200, "Agadir");
        avion2 = new Avion("Aur Bus", 150, "Casa");
    }

    @Test
    public void testCreate() {
        Avion savedAvion = avionService.save(avion1);
        Assertions.assertTrue(savedAvion.equals(avion1));
    }

    @Test
    public void testGetAll() {
        avionService.save(avion1);
        avionService.save(avion2);

        List<Avion> avions = avionService.getAll();

        Assertions.assertTrue(avions.contains(avion1));
    }

    @Test
    public void testGetById() {
        Avion savedAvion = avionService.save(avion1);

        Optional<Avion> retrievedAvion = avionService.getById(savedAvion.getNa());

        Assertions.assertTrue(retrievedAvion.isPresent());
        Assertions.assertTrue(retrievedAvion.get().equals(avion1));
    }


    @Test
    public void testUpdate() {
        Avion savedAvion = avionService.save(avion1);
        savedAvion.setNom("Updated Nom");
        avionService.update(savedAvion);

        Optional<Avion> updatedAvion = avionService.getById(savedAvion.getNa());

        Assertions.assertTrue(updatedAvion.isPresent());
        Assertions.assertEquals(updatedAvion.get().getNom(), "Updated Nom");
    }

    @Test
    public void testDeleteById() {
        Avion savedAvion = avionService.save(avion1);

        avionService.deleteById(savedAvion.getNa());

        Optional<Avion> retrievedAvion = avionService.getById(savedAvion.getNa());

        Assertions.assertFalse(retrievedAvion.isPresent());
    }
}
