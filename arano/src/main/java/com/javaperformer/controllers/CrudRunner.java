package com.javaperformer.controllers;

import com.arangodb.springframework.core.ArangoOperations;
import com.javaperformer.dao.domain.Interface;
import com.javaperformer.dao.domain.InterfaceToNE;
import com.javaperformer.dao.domain.NetworkElement;
import com.javaperformer.dao.domain.Type;
import com.javaperformer.dao.interfaces.InterfaceToNERepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class CrudRunner {

    private final ArangoOperations operations;
    private final NetworkElementRepository networkElementRepository;
    private final InterfacesRepository interfacesRepository;
    private final InterfaceToNERepository interfaceToNERepository;

    @Autowired
    public CrudRunner(NetworkElementRepository repository, ArangoOperations arangoOperations,
                      InterfacesRepository interfacesRepository, InterfaceToNERepository interfaceToNERepository) {
        this.networkElementRepository = repository;
        this.operations = arangoOperations;
        this.interfacesRepository = interfacesRepository;
        this.interfaceToNERepository = interfaceToNERepository;
    }

    public void perform() {
        operations.dropDatabase();
        final NetworkElement element = NetworkElement.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Ronald")
                .date(LocalDate.now()).build();
        final Interface firstInterFace = Interface.builder()
                .mkey(UUID.randomUUID().toString())
                .name("John")
                .type(Type.PHYSICAL.name()).build();
        final Interface secondInterFace = Interface.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Herold")
                .type(Type.LOGICAL.name()).build();
        networkElementRepository.save(element);
        interfacesRepository.save(firstInterFace);
        interfaceToNERepository.save(InterfaceToNE.builder()
                .interFace(firstInterFace)
                .networkElement(element).build());
    }
}
