package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Avion;
import com.example.demo.entity.Pilote;
import com.example.demo.service.AvionService;
import com.example.demo.service.PiloteService;
import com.example.demo.service.VolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Vol;
import com.example.demo.repository.VolRepository;

@SpringBootTest
public class VolServiceTest {

    @Autowired
    private PiloteService piloteService;
    @Autowired
    private AvionService avionService;
    @Autowired
    private VolService volService;

    @Autowired
    private VolRepository volRepository;

    private Vol vol1;
    private Vol vol2;

    private Pilote pilote;
    private Avion avion;

    @BeforeEach
    void setUp() {
        pilote = piloteService.getById(1L).get();
        avion = avionService.getById(1L).get();
        vol1 = new Vol("vol1", pilote, avion, "Paris", "New York",12 , 13 );
        vol2 = new Vol("vol2", pilote, avion, "Agadir", "Casa",14 , 16 );
    }

    @Test
    public void createVolTest() {
        Vol savedVol = volService.create(vol1);
    }

    @Test
    public void getByIdTest() {
        Vol savedVol = volService.create(vol1);
        Optional<Vol> retrievedVol = volService.getById(savedVol.getNv());
        assertTrue(retrievedVol.isPresent());

        System.out.println(savedVol.getAvion());
        //assertEquals(savedVol, retrievedVol.get());
    }

    @Test
    public void getAllTest() {
        Vol savedVol1 = volService.create(vol1);
        Vol savedVol2 = volService.create(vol2);
        List<Vol> retrievedVols = volService.getAll();
        assertTrue(retrievedVols.contains(savedVol1));
        assertTrue(retrievedVols.contains(savedVol2));
    }

    @Test
    public void updateVolTest() {
        Vol savedVol = volService.create(vol1);
        savedVol.setVd("Marseille");
        volService.update(savedVol.getNv(), savedVol);
        Optional<Vol> updatedVol = volService.getById(savedVol.getNv());
        assertTrue(updatedVol.isPresent());
        assertEquals("Marseille", updatedVol.get().getVd());
    }

    @Test
    public void deleteVolTest() {
        Vol savedVol = volService.create(vol1);
        volService.delete(savedVol.getNv());
        Optional<Vol> deletedVol = volService.getById(savedVol.getNv());
        assertFalse(deletedVol.isPresent());
    }
}
