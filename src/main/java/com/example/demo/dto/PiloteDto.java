package com.example.demo.dto;

import com.example.demo.entity.Vol;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PiloteDto {
    private Long np;
    private String nom;
    private String adresse;
    private List<Vol> vols;
}
