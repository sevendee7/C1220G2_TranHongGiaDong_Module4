package com.codegym;

import com.codegym.model.Course;
import com.codegym.model.Student;
import com.codegym.repository.ICourseRepository;
import com.codegym.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateCourse(){
        Course course1=new Course("Python","P123");
        Course course2=new Course("Java","J123");
        Course course3=new Course("C#","C123");
        Course course4=new Course("C++","C++123");
        Course course5=new Course("Js","Js123");
        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);
        entityManager.persist(course4);
        entityManager.persist(course5);
    }

    @Test
    public void createStudentCourse(){
        Course js=entityManager.find(Course.class,10);
        Student student=entityManager.find(Student.class,1);
        student.addCourse(js);
        studentRepository.save(student);
    }
}
