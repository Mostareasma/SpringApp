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
    private List<Vol> vols;

}
