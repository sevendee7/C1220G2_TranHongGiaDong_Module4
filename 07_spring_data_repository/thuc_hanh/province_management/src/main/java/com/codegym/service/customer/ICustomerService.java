package com.codegym.service.customer;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAllByProvince(Province province, Pageable pageable);
}
