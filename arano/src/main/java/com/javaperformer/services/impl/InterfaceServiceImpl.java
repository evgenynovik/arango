package com.javaperformer.services.impl;

import com.javaperformer.dao.domain.*;
import com.javaperformer.dao.interfaces.InterfaceToInterfaceRepository;
import com.javaperformer.dao.interfaces.InterfaceToNERepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import com.javaperformer.services.converters.Converter;
import com.javaperformer.services.dto.InterfaceDTO;
import com.javaperformer.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InterfaceServiceImpl implements InterfaceService {
    private final InterfaceToNERepository interfaceToNERepository;
    private final NetworkElementRepository networkElementRepository;
    private final InterfacesRepository interfacesRepository;
    private final InterfaceToInterfaceRepository interfaceToInterfaceRepository;
    private final Converter<Interface, InterfaceDTO> converter;

    @Autowired
    public InterfaceServiceImpl(InterfacesRepository interfacesRepository,
                                InterfaceToInterfaceRepository interfaceToInterfaceRepository,
                                Converter<Interface, InterfaceDTO> converter,
                                InterfaceToNERepository interfaceToNERepository,
                                NetworkElementRepository networkElementRepository) {
        this.interfacesRepository = interfacesRepository;
        this.interfaceToInterfaceRepository = interfaceToInterfaceRepository;
        this.converter = converter;
        this.interfaceToNERepository = interfaceToNERepository;
        this.networkElementRepository = networkElementRepository;
    }

    @Override
    public InterfaceDTO create(InterfaceDTO interFaceDTO) {
        Interface interFace = converter.convertToEntity(interFaceDTO);
        if (interFace.getType().equals(Type.PHYSICAL.name())) {
            Interface logicalFace = null;
            Optional<NetworkElement> optionalNetworkElement =
                    networkElementRepository.findByMkey(interFace.getParent_mkey());
            logicalFace = interfacesRepository.save(interFace);
            if (optionalNetworkElement.isPresent()) {
                interfaceToNERepository.save(InterfaceToNE.builder()
                        .interFace(logicalFace)
                        .networkElement(optionalNetworkElement.get()).build());
            } else {
                return null;
            }
            return converter.convertToDTO(logicalFace);
        } else if (interFace.getType().equals(Type.LOGICAL.name())) {
            Interface savedInterface = interfacesRepository.save(interFace);
            Optional<Interface> optionalInterface = interfacesRepository.findByMkey(interFace.getParent_mkey());
            if (optionalInterface.isPresent()) {
                interfaceToInterfaceRepository.save(InterfaceToInterface.builder()
                        .physicalInterFace(optionalInterface.get())
                        .logicalInterFace(interFace).build());
                return converter.convertToDTO(savedInterface);
            } else return null;
        }
        return converter.convertToDTO(interFace);
    }

    public void delete(String id) {
        Optional<Interface> optionalInterface = interfacesRepository.findById(id);
        if (optionalInterface.isPresent()) {
            Interface interFace = optionalInterface.get();
            if (interFace.getType().equals("PHYSICAL")) {
                Optional<InterfaceToNE> interfaceToNE =
                        interfaceToNERepository.findByNetworkElementMkey(interFace.getParent_mkey());
                List<InterfaceToInterface> interfacesList =
                        interfaceToInterfaceRepository.findByPhysicalInterFaceId(interFace.getId());
                interfacesList.forEach(interfaceToInterfaceRepository::delete);
                interfaceToNE.ifPresent(interfaceToNERepository::delete);
                interfacesRepository.delete(interFace);
            }
        }
    }
}
