package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 7", 499.99, "Apple"));
        products.put(2, new Product(2, "Samsung Galaxy Note 8", 699.99, "Samsung"));
        products.put(3, new Product(3, "BMW-X6", 49999.99, "BMW"));
        products.put(4, new Product(4, "Audi-A6", 45999.99, "Audi"));
        products.put(5, new Product(5, "Excite-150", 2999.99, "Yamaha"));
        products.put(6, new Product(6, "Winner-150", 2699.99, "Honda"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByName(String name) {
        for (int i = 1; i <= 6; i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }


    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }
}
