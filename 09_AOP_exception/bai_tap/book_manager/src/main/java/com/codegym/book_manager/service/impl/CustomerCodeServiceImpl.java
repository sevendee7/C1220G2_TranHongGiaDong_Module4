package com.codegym.book_manager.service.impl;

import com.codegym.book_manager.entity.CustomerCode;
import com.codegym.book_manager.repository.ICustomerCodeRepository;
import com.codegym.book_manager.service.ICustomerCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCodeServiceImpl implements ICustomerCodeService {

    @Autowired
    ICustomerCodeRepository customerCodeRepository;

    @Override
    public void save(CustomerCode customerCode) {
        customerCodeRepository.save(customerCode);
    }

    @Override
    public CustomerCode findById(Integer id) {
        return customerCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerCodeRepository.deleteById(id);
    }

    @Override
    public CustomerCode findByCode(String code) {
        return customerCodeRepository.findByCodeForBook(code);
    }
}
