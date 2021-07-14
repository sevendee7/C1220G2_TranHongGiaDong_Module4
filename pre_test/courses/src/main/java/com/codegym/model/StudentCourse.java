//package com.codegym.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "student_course")
//public class StudentCourse {
//
//    @EmbeddedId
//    private CompositeKey id;
//
//    @ManyToOne
//    @MapsId("student_id")
//    @JoinColumn(name = "student_id")
//    private Student student;
//
//    @ManyToOne
//    @MapsId("course_id")
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    public StudentCourse() {
//    }
//
//    public StudentCourse(CompositeKey id, Student student, Course course) {
//        this.id = id;
//        this.student = student;
//        this.course = course;
//    }
//
//    public CompositeKey getId() {
//        return id;
//    }
//
//    public void setId(CompositeKey id) {
//        this.id = id;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//}
