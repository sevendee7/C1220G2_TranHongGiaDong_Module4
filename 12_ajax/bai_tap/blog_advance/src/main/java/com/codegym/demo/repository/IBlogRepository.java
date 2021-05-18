package com.codegym.demo.repository;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogNameContains(String name);

}
