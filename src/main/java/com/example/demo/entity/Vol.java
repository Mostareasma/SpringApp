package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vols")

public class Vol {
    @Id
    private String nv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "np")
    private Pilote pilote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "na")
    private Avion avion;

    private String vd;
    private String va;
    private int hd;
    private int ha;
}


