package com.completedaddtocart.service;

import com.completedaddtocart.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long Id);
    Product save(Product product);
}
