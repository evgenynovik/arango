package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.InterfaceToInterface;

public interface InterfaceToInterfaceRepository extends ArangoRepository<InterfaceToInterface, String> {
}
