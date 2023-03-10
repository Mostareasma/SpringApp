package com.example.demo.dto;


import com.example.demo.entity.Avion;
import com.example.demo.entity.Vol;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AvionDto {
    private String nom;
    private int capacite;
    private String localite;

    @Override
    public boolean equals(Object obj) {
        Avion toCompare = (Avion) obj;
        if (!this.getNom().equals(toCompare.getNom())) return false;
        if (!this.getLocalite().equals(toCompare.getLocalite())) return false;
        if (this.getCapacite() != toCompare.getCapacite()) return false;
        return true;
    }

}
