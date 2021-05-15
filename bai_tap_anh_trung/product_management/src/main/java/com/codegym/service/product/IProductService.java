package com.codegym.service.product;

import com.codegym.entity.Category;
import com.codegym.entity.Product;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {

    Page<Product> findAllByCategory(Category category, Pageable pageable);
}
