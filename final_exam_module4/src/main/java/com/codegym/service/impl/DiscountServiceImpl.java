package com.codegym.service.impl;

import com.codegym.model.Discount;
import com.codegym.repository.IDiscountRepository;
import com.codegym.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements IDiscountService {
    @Autowired
    private IDiscountRepository discountRepository;

    @Override
    public Page<Discount> findAll(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public Page<Discount> findDiscountByAmount(String amount, Pageable pageable) {
        return discountRepository.findAllByAmountContains(amount, pageable);
    }

    @Override
    public Discount findById(Integer id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void deleteById(Integer id) {
        discountRepository.deleteById(id);
    }
}
