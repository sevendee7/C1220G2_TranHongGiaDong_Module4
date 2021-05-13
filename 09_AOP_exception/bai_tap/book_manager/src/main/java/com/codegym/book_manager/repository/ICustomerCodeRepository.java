package com.codegym.book_manager.repository;

import com.codegym.book_manager.entity.CustomerCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerCodeRepository extends JpaRepository<CustomerCode, Integer> {
    CustomerCode findByCodeForBook(String code);
}
