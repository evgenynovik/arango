package com.javaperformer.controllers;

import com.javaperformer.services.dto.InterfaceDTO;
import com.javaperformer.services.interfaces.InterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InterfaceController {
    private final InterfaceService interfaceService;

    public InterfaceController(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    @PostMapping("general/interfaces")
    public ResponseEntity<InterfaceDTO> create(@Valid @RequestBody InterfaceDTO interfaceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interfaceService.create(interfaceDTO));
    }
}
