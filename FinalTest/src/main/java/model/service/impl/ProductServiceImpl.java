package model.service.impl;

import model.bean.Product;
import model.repository.CRUDRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.CRUDService;

import java.util.List;

public class ProductServiceImpl implements CRUDService<Product> {

    CRUDRepository<Product> productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
