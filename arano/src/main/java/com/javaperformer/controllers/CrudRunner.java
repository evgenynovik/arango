package com.javaperformer.controllers;

import com.arangodb.springframework.core.ArangoOperations;
import com.javaperformer.dao.domain.Interface;
import com.javaperformer.dao.domain.NetworkElement;
import com.javaperformer.dao.domain.Type;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@Component
public class CrudRunner {

    private final ArangoOperations operations;
    private final NetworkElementRepository repository;
    private final InterfacesRepository interfacesRepository;

    @Autowired
    public CrudRunner(NetworkElementRepository repository, ArangoOperations arangoOperations,
                      InterfacesRepository interfacesRepository) {
        this.repository = repository;
        this.operations = arangoOperations;
        this.interfacesRepository = interfacesRepository;
    }

    public void perform() {
        operations.dropDatabase();
        final NetworkElement element = NetworkElement.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Ronald")
                .date(LocalDate.now()).build();
        final Interface interf = Interface.builder()
                .mkey(UUID.randomUUID().toString())
                .name("John")
                .type(Type.PHYSICAL.name()).build();
        final Interface interf2 = Interface.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Herold")
                .type(Type.LOGICAL.name()).build();
        repository.save(element);
        interfacesRepository.save(interf);
        System.out.printf("element saved in the database with id: '%s'%n", element.getId());
        System.out.printf("element saved in the database with id: '%s'%n", interf.getId());
        final NetworkElement foundElement = repository.findById(element.getId()).orElse(null);
        final Interface foundInterface = interfacesRepository.findById(interf.getId()).orElse(null);
        System.out.printf("Found %s%n", foundElement);
        System.out.printf("Found %s%n", foundInterface);
    }
}
