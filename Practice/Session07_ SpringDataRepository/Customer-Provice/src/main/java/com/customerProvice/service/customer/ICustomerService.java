package com.customerProvice.service.customer;

import com.customerProvice.model.Customer;
import com.customerProvice.model.Province;
import com.customerProvice.service.IGenerateService;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
