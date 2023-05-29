package com.completedaddtocart.service;

import com.completedaddtocart.model.Product;
import com.completedaddtocart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceIMPL implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long Id) {
        productRepository.deleteById(Id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


}
