package com.example.carro.domain.dto;

import com.example.carro.domain.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {

    private Long id;
    private String nome, tipo;

    public static CarroDTO create(Carro c) {
        ModelMapper modelmapper = new ModelMapper();
        return modelmapper.map(c, CarroDTO.class);
    }
}
