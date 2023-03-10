package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pilotes")
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long np;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy="pilote")
    private List<Vol> vols;
}
