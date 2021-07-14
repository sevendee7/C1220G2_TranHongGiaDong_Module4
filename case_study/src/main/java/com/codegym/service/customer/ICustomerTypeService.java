package com.codegym.service.customer;

import com.codegym.model.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
