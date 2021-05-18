package com.codegym.demo.service.blog;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import com.codegym.demo.service.IGeneralService;

import java.util.List;
import java.util.Optional;


public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogName(String name);
}
