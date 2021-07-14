package com.codegym.demo.service.blog;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

    Page<Blog> findAllByBlogName(String name, Pageable pageable);
}
