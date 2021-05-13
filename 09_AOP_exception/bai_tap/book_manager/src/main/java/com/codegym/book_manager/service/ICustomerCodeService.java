package com.codegym.book_manager.service;

import com.codegym.book_manager.entity.CustomerCode;

public interface ICustomerCodeService {

    void save(CustomerCode customerCode);

    CustomerCode findById(Integer id);

    void delete(Integer id);

    CustomerCode findByCode(String code);
}
