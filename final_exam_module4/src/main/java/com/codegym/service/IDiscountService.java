package com.codegym.service;

import com.codegym.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDiscountService {

    Page<Discount> findAll(Pageable pageable);

    Page<Discount> findDiscountByAmount(String amount,Pageable pageable);

    Discount findById(Integer id);

    void save(Discount discount);

    void deleteById(Integer id);
}
