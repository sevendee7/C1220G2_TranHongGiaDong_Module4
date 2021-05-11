package com.codegym.demo.service.blog;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

    Page<Blog> findAllByBlogName(Optional<String> name, Pageable pageable);
}
