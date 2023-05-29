package com.blogrestful.service.design;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;

public interface IServiceGeneric<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void deleteById(Long id);

    T save(T t);

}
