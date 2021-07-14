package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    Page<Product> findAfterSearch(int pageNum, String sortField, String sortDir, String name, String brand, String categoryName);

    List<Product> findTop5();

    Product findById(Integer id);

    void save(Product product);

    void delete(Integer id);
}
