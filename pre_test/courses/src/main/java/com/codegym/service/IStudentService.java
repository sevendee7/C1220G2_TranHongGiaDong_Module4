package com.codegym.service;

import com.codegym.model.Course;
import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAllStudent();


    Student findStudentById(Integer id);

    void save(Student student);

    void delete(Integer id);
}
