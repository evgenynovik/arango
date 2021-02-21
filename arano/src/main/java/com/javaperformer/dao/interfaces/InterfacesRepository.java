package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.Interface;

import java.util.Optional;

public interface InterfacesRepository extends ArangoRepository<Interface, String> {
    Optional<Interface> findByMkey(String s);
}
