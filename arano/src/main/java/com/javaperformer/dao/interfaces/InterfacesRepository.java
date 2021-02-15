package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.Interface;

public interface InterfacesRepository extends ArangoRepository<Interface, String> {
}
