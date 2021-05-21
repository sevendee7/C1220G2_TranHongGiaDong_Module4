package com.codegym.repository;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogNameContains(String name);

    @Query( value = "select * from blog limit ?1" , nativeQuery = true)
    List<Blog> getBlogs(int limit);
}
