package com.codegym.service.customer;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findAllByProvince(Province province);
}
