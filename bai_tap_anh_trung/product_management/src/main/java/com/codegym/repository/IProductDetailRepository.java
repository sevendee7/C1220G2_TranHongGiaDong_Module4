package com.codegym.repository;

import com.codegym.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
