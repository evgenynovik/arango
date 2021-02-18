package com.javaperformer.services.converters;

import com.javaperformer.dao.domain.Interface;
import com.javaperformer.services.dto.InterfaceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterfaceConverter implements Converter<Interface, InterfaceDTO> {
    private final ModelMapper modelMapper;

    @Autowired
    public InterfaceConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public InterfaceDTO convertToDTO(Interface entity) {
        return modelMapper.map(entity, InterfaceDTO.class);
    }

    @Override
    public Interface convertToEntity(InterfaceDTO dto) {
        return modelMapper.map(dto, Interface.class);
    }
}
