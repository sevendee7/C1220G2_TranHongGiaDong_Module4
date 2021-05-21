package com.codegym.service.blog;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogName(String name);
}
