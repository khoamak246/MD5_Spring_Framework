package com.orm.customermanagement.service;

import com.orm.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    void deleteById(Long id);

    void save(Customer customer);

}
