package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes studentClasses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonManagedReference
    private Set<Course> courses;

    public Student() {
    }

    public Student(String code, String name, Classes studentClasses, Set<Course> courses) {
        this.code = code;
        this.name = name;
        this.studentClasses = studentClasses;
        this.courses = courses;
    }

    public Student(String code, String name, Classes studentClasses) {
        this.code = code;
        this.name = name;
        this.studentClasses = studentClasses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classes getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(Classes studentClasses) {
        this.studentClasses = studentClasses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
