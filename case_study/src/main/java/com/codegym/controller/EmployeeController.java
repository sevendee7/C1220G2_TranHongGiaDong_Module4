package com.codegym.controller;

import com.codegym.model.entity.*;
import com.codegym.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    private final IPositionService positionService;

    private final IDepartmentService departmentService;

    private final IEducationService educationService;

    private final IRoleService roleService;

    private final IUserService userService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService, IPositionService positionService, IDepartmentService departmentService, IEducationService educationService, IRoleService roleService, IUserService userService) {
        this.employeeService = employeeService;
        this.positionService = positionService;
        this.departmentService = departmentService;
        this.educationService = educationService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @ModelAttribute
    public void detail(Model model) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educations", educationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }

    @ModelAttribute("educations")
    public List<EducationBackground> getListEducation() {
        return educationService.findAll();
    }

    @ModelAttribute("departments")
    public List<Department> getListDepartments() { return departmentService.findAll(); }

    @GetMapping
    public ModelAndView showHomePage(@SortDefault(sort = "name", direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("/employee/list","listEmployee", employeeService.findAll(pageable));
    }

    @GetMapping("/create-user/{employeeId}")
    public String createUser(@PathVariable("employeeId") Integer employeeId, Model model) {
        model.addAttribute("employeeExist", employeeService.findById(employeeId));
        model.addAttribute("user", new User());
        return "/employee/create_user";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute User user) {
        Role roleAdmin = roleService.findById(1) ;
        roleAdmin.getUsers().add(user);
        user.getRoles().add(roleAdmin);
        userService.save(user);
        return "redirect:/employee";
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/employee/create","employee", new Employee());
    }

    @PostMapping("/save")
    public String createEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        employeeService.save(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("success","New employee has been created !");
        return "/employee/create";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewPage(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return new ModelAndView("/employee/view", "employee", employee);
        } else {
            return new ModelAndView("home");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("/employee/edit", "employee", employee);
    }

    @PostMapping("/edit")
    public String editEmployee(Employee employee, RedirectAttributes ra) {
        employeeService.save(employee);
        ra.addFlashAttribute("success", "Employee has been updated !");
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("/employee/delete", "employee", employee);
    }

    @PostMapping("/delete")
    public String deleteBlog(Employee employee, RedirectAttributes ra, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            employeeService.remove(employee.getId());
            ra.addFlashAttribute("success", "Employee has been deleted !");
        }
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public String showSearchList(@PageableDefault(value = 5) Pageable pageable, @RequestParam String keyword, Model model) {
        if (keyword != null) {
            Page<Employee> listEmployee = employeeService.findAllByNameContains(keyword,pageable);
            model.addAttribute("listEmployee", listEmployee);
            model.addAttribute("keyword", keyword);
            return "/employee/search";
        }
        Page<Employee> listEmployee = employeeService.findAll(pageable);
        model.addAttribute("listEmployee", listEmployee);
        return "/employee/list";
    }
}
