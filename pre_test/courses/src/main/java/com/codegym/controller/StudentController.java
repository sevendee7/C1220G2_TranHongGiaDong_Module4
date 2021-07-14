package com.codegym.controller;

import com.codegym.model.Course;
import com.codegym.model.Student;
import com.codegym.service.IClassesService;
import com.codegym.service.ICourseService;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    private final ICourseService courseService;
    private final IClassesService classesService;
    private final IStudentService studentService;

    @Autowired
    public StudentController(ICourseService courseService, IClassesService classesService, IStudentService studentService) {
        this.courseService = courseService;
        this.classesService = classesService;
        this.studentService = studentService;
    }

    @ModelAttribute
    public void details(Model model) {
        model.addAttribute("courses", courseService.findAllCourse());
        model.addAttribute("classes", classesService.findAllClasses());
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        return new ModelAndView("/home", "students", studentService.findAllStudent());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/create", "student", new Student());
    }

    @PostMapping("/save")
    public String createEmployee(Student student, Model model) {
        studentService.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("success", "New student has been created !");
        return "redirect:/create";
    }

    @GetMapping("/add-course/{id}")
    public String showAddCourse(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("studentExist", studentService.findStudentById(id));
        model.addAttribute("courses", courseService.findAllCourse());
        return "addCourse";
    }

    @GetMapping("/add-course/save")
    public String saveStudentCourse(@RequestParam("studentId") Integer studentId,
                                    @RequestParam("courseId") Integer courseId
    ) {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findById(courseId);
        student.addCourse(course);
        studentService.save(student);
        return "redirect:/home";
    }
}
