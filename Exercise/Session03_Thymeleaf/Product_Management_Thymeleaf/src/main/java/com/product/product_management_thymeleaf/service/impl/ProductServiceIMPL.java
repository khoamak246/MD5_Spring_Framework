package com.product.product_management_thymeleaf.service.impl;

import com.product.product_management_thymeleaf.model.Product;
import com.product.product_management_thymeleaf.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceIMPL implements IProductService {
    private static final Map<Long,Product> products = new HashMap();
    static {
        products.put(1L, new Product(1, "Giay", 100, 100));
        products.put(2L, new Product(2, "Dep", 200, 200));
        products.put(3L, new Product(3, "Ao", 300, 300));
        products.put(4L, new Product(4, "Quan", 400, 400));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public Product save(Product product) {
        return products.put(product.getId(), product);
    }

    @Override
    public Product findById(long id) {
        return products.get(id);
    }

    @Override
    public Product update(Product product) {
        return products.put(product.getId(), product);
    }

    @Override
    public void delete(long id) {
        products.remove(id);
    }
}
