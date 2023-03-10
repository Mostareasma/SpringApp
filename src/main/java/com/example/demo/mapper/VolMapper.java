package com.example.demo.mapper;

import com.example.demo.entity.Vol;
import com.example.demo.dto.VolDto;
import org.modelmapper.ModelMapper;

public class VolMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Vol dtoToEntity(VolDto volDto, Class<Vol> entityClass) {
        return MODEL_MAPPER.map(volDto, entityClass);
    }

    public static VolDto entityToDto(Vol vol) {
        return MODEL_MAPPER.map(vol, VolDto.class);
    }
}
