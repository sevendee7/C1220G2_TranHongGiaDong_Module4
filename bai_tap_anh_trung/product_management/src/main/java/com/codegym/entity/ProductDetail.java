package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String description;

    @OneToOne(mappedBy = "productDetail",cascade = CascadeType.ALL)
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(Long id, String description, Product product) {
        this.id = id;
        this.description = description;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
