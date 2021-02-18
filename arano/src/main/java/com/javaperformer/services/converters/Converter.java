package com.javaperformer.services.converters;

import com.javaperformer.dao.domain.BaseEntity;

public interface Converter<T extends BaseEntity, Y> {
    Y convertToDTO(T entity);

    T convertToEntity(Y dto);
}
