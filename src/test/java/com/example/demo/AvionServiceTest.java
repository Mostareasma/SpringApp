package com.example.demo;

import com.example.demo.dto.AvionDto;
import com.example.demo.entity.Avion;
import com.example.demo.mapper.AvionMapper;
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

    private AvionDto avion1;
    private AvionDto avion2;

    @BeforeEach
    void setUp() {
        avion1 = AvionDto.builder()
                .nom("RAM")
                .capacite(200)
                .localite("Agadir")
                .build();
        avion2 = AvionDto.builder()
                .nom("Air Bus")
                .capacite(300)
                .localite("Paris")
                .build();
    }

    @Test
    public void testCreate() {
        Avion savedAvion = avionService.save(avion1);
        Assertions.assertTrue(avion1.equals(savedAvion));
    }

    @Test
    public void testGetAll() {
        avionService.save(avion1);
        avionService.save(avion2);

        List<Avion> avions = avionService.getAll();

        Assertions.assertTrue(avions.contains(avion1));
    }

}
