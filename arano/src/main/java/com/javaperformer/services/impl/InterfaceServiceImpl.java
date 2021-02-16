package com.javaperformer.services.impl;

import com.javaperformer.dao.domain.Interface;
import com.javaperformer.dao.domain.InterfaceToInterface;
import com.javaperformer.dao.domain.Type;
import com.javaperformer.dao.interfaces.InterfaceToInterfaceRepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InterfaceServiceImpl implements InterfaceService {

    private final InterfacesRepository interfacesRepository;
    private final InterfaceToInterfaceRepository interfaceToInterfaceRepository;

    @Autowired
    public InterfaceServiceImpl(InterfacesRepository interfacesRepository,
                                InterfaceToInterfaceRepository interfaceToInterfaceRepository) {
        this.interfacesRepository = interfacesRepository;
        this.interfaceToInterfaceRepository = interfaceToInterfaceRepository;
    }

    @Override
    public Interface create(Interface interFace) {
        if (interFace.getType().equals(Type.LOGICAL.name())) {
            return interfacesRepository.save(interFace);
        } else if (interFace.getType().equals(Type.PHYSICAL.name())) {
            if (!interFace.getInterFaces().isEmpty()) {
                interFace.getInterFaces().stream()
                        .map(iteratableInterFace -> {
                            interfacesRepository.save(interFace);
                            Interface tempInterFace = interfacesRepository.save(iteratableInterFace);
                            interfaceToInterfaceRepository.save(InterfaceToInterface.builder()
                                    .physicalInterFace(interFace)
                                    .logicalInterFace(iteratableInterFace).build());
                            return tempInterFace;
                        }).collect(Collectors.toList());
            }
        } return null;
    }
}
