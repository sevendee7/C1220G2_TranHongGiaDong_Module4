package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    public Product() {
    }

    public Product(Long id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String name, Double price, Category category, ProductDetail productDetail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.productDetail = productDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
