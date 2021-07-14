package com.codegym.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_background")
public class EducationBackground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_background_id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "educationBackground", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public EducationBackground() {
    }

    public EducationBackground( String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
