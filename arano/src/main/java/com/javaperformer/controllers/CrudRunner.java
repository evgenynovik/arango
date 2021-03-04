package com.javaperformer.controllers;

import com.arangodb.springframework.core.ArangoOperations;
import com.javaperformer.dao.domain.NetworkElement;
import com.javaperformer.dao.domain.Type;
import com.javaperformer.dao.interfaces.InterfaceToInterfaceRepository;
import com.javaperformer.dao.interfaces.InterfaceToNERepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import com.javaperformer.services.dto.InterfaceDTO;
import com.javaperformer.services.interfaces.InterfaceService;
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
//        operations.dropDatabase();
        final NetworkElement element = NetworkElement.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Ronald")
                .date(LocalDate.now()).build();

        final InterfaceDTO secondInterFace = InterfaceDTO.builder()
                .mkey(UUID.randomUUID().toString())
                .name("Herold")
                .parent_mkey("3d12ce3b-cfa1-4cbb-91f2-7a323110cf0a")
                .type(Type.PHYSICAL.name()).build();
        final InterfaceDTO firstInterFace = InterfaceDTO.builder()
                .mkey(UUID.randomUUID().toString())
                .parent_mkey("8b4015ec-c0c2-4067-80f7-5911eb041d41")
                .name("Fr")
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
