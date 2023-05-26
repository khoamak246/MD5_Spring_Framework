package com.jpaStoreProcedure.service;

import com.jpaStoreProcedure.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
