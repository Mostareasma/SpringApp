package com.example.demo.mapper;

import com.example.demo.entity.Pilote;
import com.example.demo.dto.PiloteDto;
import org.modelmapper.ModelMapper;

public class PiloteMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Pilote dtoToEntity(PiloteDto piloteDto, Class<Pilote> entityClass) {
        return MODEL_MAPPER.map(piloteDto, entityClass);
    }

    public static PiloteDto entityToDto(Pilote pilote) {
        return MODEL_MAPPER.map(pilote, PiloteDto.class);
    }
}
