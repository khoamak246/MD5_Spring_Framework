package com.ajax_blog.service.design;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void deleteById(Long id);

    T save(T t);

}
