package com.codegym.demo.repository;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

    Page<Blog> findAllByBlogNameContains(Optional<String> name, Pageable pageable);

}
