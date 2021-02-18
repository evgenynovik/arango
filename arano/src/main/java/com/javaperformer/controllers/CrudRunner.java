package com.javaperformer.controllers;

import com.arangodb.springframework.core.ArangoOperations;
import com.javaperformer.dao.domain.*;
import com.javaperformer.dao.interfaces.InterfaceToInterfaceRepository;
import com.javaperformer.dao.interfaces.InterfaceToNERepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import com.javaperformer.services.dto.InterfaceDTO;
import com.javaperformer.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

@Component
public class CrudRunner {

    private final ArangoOperations operations;
    private final NetworkElementRepository networkElementRepository;
    private final InterfacesRepository interfacesRepository;
    private final InterfaceToNERepository interfaceToNERepository;
    private final InterfaceToInterfaceRepository interfaceToInterfaceRepository;
    private final InterfaceService interfaceService;

    @Autowired
    public CrudRunner(NetworkElementRepository repository, ArangoOperations arangoOperations,
                      InterfacesRepository interfacesRepository, InterfaceToNERepository interfaceToNERepository,
                      InterfaceToInterfaceRepository interfaceToInterfaceRepository, InterfaceService interfaceService) {
        this.networkElementRepository = repository;
        this.operations = arangoOperations;
        this.interfacesRepository = interfacesRepository;
        this.interfaceToNERepository = interfaceToNERepository;
        this.interfaceToInterfaceRepository = interfaceToInterfaceRepository;
        this.interfaceService = interfaceService;
    }

    public void perform() {
        operations.dropDatabase();
        final NetworkElement element = NetworkElement.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Ronald")
                .date(LocalDate.now()).build();

        final Interface secondInterFace = Interface.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Herold")
                .type(Type.LOGICAL.name()).build();
        final InterfaceDTO firstInterFace = InterfaceDTO.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Juno")
                .state(true)
                .type(Type.LOGICAL.name()).build();

//        networkElementRepository.save(element);
//        interfacesRepository.save(firstInterFace);
//        interfacesRepository.save(secondInterFace);
//        interfaceToNERepository.save(InterfaceToNE.builder()
//                .interFace(firstInterFace)
//                .networkElement(element).build());
//        interfaceToInterfaceRepository.save(InterfaceToInterface.builder()
//                .logicalInterFace(secondInterFace)
//                .physicalInterFace(firstInterFace).build());

        interfaceService.create(firstInterFace);
    }
}
