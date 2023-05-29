package com.product_mng.service;

import com.product_mng.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

    Optional<Product> findById(Long id);

}
