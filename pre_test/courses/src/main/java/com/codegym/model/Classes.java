package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String code;

    @OneToMany(mappedBy = "studentClasses")
    private Set<Student> students;

    public Classes() {
    }

    public Classes(String code, Set<Student> students) {
        this.code = code;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return code;
    }

    public void setName(String code) {
        this.code = code;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
