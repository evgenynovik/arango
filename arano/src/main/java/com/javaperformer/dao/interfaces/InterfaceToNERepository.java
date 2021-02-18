package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.InterfaceToNE;

public interface InterfaceToNERepository extends ArangoRepository<InterfaceToNE, String> {
}
