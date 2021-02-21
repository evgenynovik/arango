package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.InterfaceToNE;

import java.util.Optional;

public interface InterfaceToNERepository extends ArangoRepository<InterfaceToNE, String> {
    Optional<InterfaceToNE> findByNetworkElementMkey(String s);
}
