package com.javaperformer.services.converters;

public interface Converter<T, Y> {
    Y convertToDTO(T entity);

    T convertToEntity(Y dto);
}
