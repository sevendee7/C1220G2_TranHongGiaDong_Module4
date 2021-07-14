package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> getByNameContainingAndBrandContainingAndCategory_NameContaining(String name, String brand, String categoryName, Pageable pageable);

    List<Product> findTop5ByOrderByPriceDesc();

    List<Product> findTop3ByOrderByPriceDesc();
}
