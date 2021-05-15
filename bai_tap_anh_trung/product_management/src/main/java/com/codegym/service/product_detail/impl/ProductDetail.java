package com.codegym.service.product_detail.impl;

import com.codegym.repository.IProductDetailRepository;
import com.codegym.service.product_detail.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductDetail implements IProductDetailService {

    @Autowired
    IProductDetailRepository productDetailRepository;

    @Override
    public Page<com.codegym.entity.ProductDetail> findAll(Pageable pageable) {
        return productDetailRepository.findAll(pageable);
    }

    @Override
    public com.codegym.entity.ProductDetail findById(Long id) {
        return productDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.codegym.entity.ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void remove(Long id) {
        productDetailRepository.deleteById(id);
    }
}
