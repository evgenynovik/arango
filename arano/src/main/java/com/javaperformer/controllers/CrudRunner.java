package com.javaperformer.controllers;

import com.arangodb.springframework.core.ArangoOperations;
import com.javaperformer.dao.domain.NetworkElement;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CrudRunner {

    private final ArangoOperations operations;
    private final NetworkElementRepository repository;

    @Autowired
    public CrudRunner(NetworkElementRepository repository, ArangoOperations arangoOperations) {
        this.repository = repository;
        this.operations = arangoOperations;
    }

    public void perform() {
        operations.dropDatabase();
        final NetworkElement element = NetworkElement.builder()
                .id("1")
                .name("Jimmi")
                .alive(true)
                .age(17).build();
        repository.save(element);
        System.out.printf("element saved in the database with id: '%s'%n", element.getId());
        final NetworkElement foundElement = repository.findById(element.getId()).orElse(null);
        System.out.printf("Found %s%n", foundElement);
    }
}
