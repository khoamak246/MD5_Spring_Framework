package com.customerProvice.service.customer;

import com.customerProvice.model.Customer;
import com.customerProvice.model.Province;
import com.customerProvice.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Customer> {
//    Iterable<Customer> findAllByProvince(Province province);


    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
