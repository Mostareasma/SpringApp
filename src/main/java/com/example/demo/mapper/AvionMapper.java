package com.example.demo.mapper;

import com.example.demo.entity.Avion;
import com.example.demo.dto.AvionDto;
import org.modelmapper.ModelMapper;

public class AvionMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Avion dtoToEntity(AvionDto avionDto) {
        return MODEL_MAPPER.map(avionDto, Avion.class);
    }

    public static AvionDto entityToDto(Avion avion) {
        return MODEL_MAPPER.map(avion, AvionDto.class);
    }
}
