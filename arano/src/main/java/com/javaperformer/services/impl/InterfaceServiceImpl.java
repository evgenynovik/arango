package com.javaperformer.services.impl;

import com.javaperformer.dao.domain.Interface;
import com.javaperformer.dao.domain.InterfaceToInterface;
import com.javaperformer.dao.domain.Type;
import com.javaperformer.dao.interfaces.InterfaceToInterfaceRepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.services.converters.Converter;
import com.javaperformer.services.dto.InterfaceDTO;
import com.javaperformer.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InterfaceServiceImpl implements InterfaceService {

    private final InterfacesRepository interfacesRepository;
    private final InterfaceToInterfaceRepository interfaceToInterfaceRepository;
    private final Converter<Interface, InterfaceDTO> converter;

    @Autowired
    public InterfaceServiceImpl(InterfacesRepository interfacesRepository,
                                InterfaceToInterfaceRepository interfaceToInterfaceRepository,
                                Converter<Interface, InterfaceDTO> converter) {
        this.interfacesRepository = interfacesRepository;
        this.interfaceToInterfaceRepository = interfaceToInterfaceRepository;
        this.converter = converter;
    }

    @Override
    public InterfaceDTO create(InterfaceDTO interFaceDTO) {
        Interface interFace = converter.convertToEntity(interFaceDTO);
        if (interFace.getType().equals(Type.LOGICAL.name())) {
            return converter.convertToDTO(interfacesRepository.save(interFace));
        } else if (interFace.getType().equals(Type.PHYSICAL.name())) {
            if (!interFace.getInterFaces().isEmpty()) {
                interFace.getInterFaces().stream()
                        .map(iteratableInterFace -> {
                            interfacesRepository.save(interFace);
                            Interface tempInterFace = interfacesRepository.save(iteratableInterFace);
                            interfaceToInterfaceRepository.save(InterfaceToInterface.builder()
                                    .physicalInterFace(interFace)
                                    .logicalInterFace(iteratableInterFace).build());
                            return converter.convertToDTO(tempInterFace);
                        }).collect(Collectors.toList());
            }
        } return null;
    }
}
