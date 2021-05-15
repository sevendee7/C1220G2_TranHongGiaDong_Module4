package com.codegym.repository;

import com.codegym.entity.Category;
import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategory(Category category, Pageable pageable);

}
