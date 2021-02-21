package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.NetworkElement;

import java.util.Optional;

public interface NetworkElementRepository extends ArangoRepository<NetworkElement, String> {
    Optional<NetworkElement> findByMkey(String s);
}
