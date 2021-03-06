package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findByName(String name);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);
}
