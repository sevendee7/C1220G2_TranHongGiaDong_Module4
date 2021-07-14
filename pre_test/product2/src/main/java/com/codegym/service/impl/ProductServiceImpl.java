package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private static final int PAGE_SIZE = 5;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAfterSearch(int pageNum, String sortField, String sortDir, String name, String brand, String categoryName) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE, sort);
        if (name != null || brand != null || categoryName != null) {
            return productRepository.getByNameContainingAndBrandContainingAndCategory_NameContaining(name,brand,categoryName,pageable);
        }
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findTop5() {
        if (productRepository.findTop5ByOrderByPriceDesc() != null ) {
            return productRepository.findTop5ByOrderByPriceDesc();
        }
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
