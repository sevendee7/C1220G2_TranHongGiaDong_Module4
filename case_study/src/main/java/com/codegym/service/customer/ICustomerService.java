package com.codegym.service.customer;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAllCustomers();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    Page<Customer> findAllByNameContains(String name, Pageable pageable);
}
