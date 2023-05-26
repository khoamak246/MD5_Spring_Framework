package com.jpaStoreProcedure.repository;

import com.jpaStoreProcedure.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}

