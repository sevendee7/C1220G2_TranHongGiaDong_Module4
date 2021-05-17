package com.codegym.repository;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByBlogNameContains(String name, Pageable pageable);

}
