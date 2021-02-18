package com.javaperformer.services.impl;

import com.javaperformer.dao.domain.Interface;
import com.javaperformer.dao.domain.InterfaceToNE;
import com.javaperformer.dao.domain.NetworkElement;
import com.javaperformer.dao.interfaces.InterfaceToNERepository;
import com.javaperformer.dao.interfaces.InterfacesRepository;
import com.javaperformer.dao.interfaces.NetworkElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterfaceToNEServiceImpl {
    private final InterfaceToNERepository interfaceToNERepository;
    private final InterfacesRepository interfacesRepository;
    private final NetworkElementRepository networkElementRepository;

    @Autowired
    public InterfaceToNEServiceImpl(InterfaceToNERepository interfaceToNERepository, InterfacesRepository interfacesRepository, NetworkElementRepository networkElementRepository) {
        this.interfaceToNERepository = interfaceToNERepository;
        this.interfacesRepository = interfacesRepository;
        this.networkElementRepository = networkElementRepository;
    }

    public InterfaceToNE create(String interfaceId, String networkElementId) {
        Optional<NetworkElement> optionalNetworkElement = networkElementRepository.findById(networkElementId);
        if (!optionalNetworkElement.isPresent()) {
            return null;
        }
        Optional<Interface> optionalInterface = interfacesRepository.findById(interfaceId);
        return optionalInterface.map(anInterface -> interfaceToNERepository.save(InterfaceToNE.builder()
                .interFace(anInterface)
                .networkElement(optionalNetworkElement.get())
                .build())).orElse(null);
    }
}
