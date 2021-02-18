package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.NetworkElement;

public interface NetworkElementRepository extends ArangoRepository<NetworkElement, String> {
}
