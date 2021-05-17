package com.codegym.service.blog;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByBlogName(String name, Pageable pageable);
}
