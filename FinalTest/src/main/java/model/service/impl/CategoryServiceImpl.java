package model.service.impl;

import model.bean.Category;
import model.repository.CRUDRepository;
import model.repository.impl.CategoryRepositoryImpl;
import model.service.CRUDService;

import java.util.List;

public class CategoryServiceImpl implements CRUDService<Category> {

    CRUDRepository<Category> categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
