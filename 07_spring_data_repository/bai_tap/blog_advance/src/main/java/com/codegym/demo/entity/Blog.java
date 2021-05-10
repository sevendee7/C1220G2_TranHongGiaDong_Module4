package com.codegym.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String blogName;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Blog() {
    }

    public Blog(Long id, String blogName, String content) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
    }

    public Blog(Long id, String blogName, String content, Category category) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
