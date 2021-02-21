package com.javaperformer.dao.interfaces;

import com.arangodb.springframework.repository.ArangoRepository;
import com.javaperformer.dao.domain.InterfaceToInterface;

import java.util.List;

public interface InterfaceToInterfaceRepository extends ArangoRepository<InterfaceToInterface, String> {
    List<InterfaceToInterface> findByPhysicalInterFaceId(String s);
}
