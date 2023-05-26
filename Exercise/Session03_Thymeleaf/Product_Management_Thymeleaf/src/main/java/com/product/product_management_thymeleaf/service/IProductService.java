package com.product.product_management_thymeleaf.service;

import com.product.product_management_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product save(Product product);

    Product findById(long id);

    Product update(Product product);

    void delete(long id);
}
