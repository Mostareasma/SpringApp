package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "avions")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long na;
    private String nom;
    private int capacite;
    private String localite;

    @OneToMany(mappedBy="avion")
    private List<Vol> vols;

}
