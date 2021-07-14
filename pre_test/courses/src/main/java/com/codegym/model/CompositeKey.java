//package com.codegym.model;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//
//@Embeddable
//public class CompositeKey implements Serializable {
//
//    @Column(name = "student_id")
//    Integer studentId;
//
//    @Column(name = "course_id")
//    Integer courseId;
//
//    public CompositeKey() {
//    }
//
//    public CompositeKey(Integer studentId, Integer courseId) {
//        this.studentId = studentId;
//        this.courseId = courseId;
//    }
//
//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//}
