package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/customers")
    public void addNewCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
    }
//    @ModelAttribute("customerTypes")
//    public List<CustomerType> getListCustomerType() {
//        return customerTypeService.findAll();
//    }
//
//    @GetMapping
//    public ModelAndView showHomePage(@SortDefault(sort = "customerCode", direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable) {
//        return new ModelAndView("/customer/list","listCustomer", customerService.findAll(pageable));
//    }
//
//    @GetMapping("/search")
//    public String showSearchList(@PageableDefault(value = 5) Pageable pageable, @RequestParam String keyword, Model model) {
//        if (keyword != null) {
//            Page<Customer> listCustomer = customerService.findAllByNameContains(keyword,pageable);
//            model.addAttribute("listCustomer", listCustomer);
//            model.addAttribute("keyword", keyword);
//            return "/customer/search";
//        }
//        Page<Customer> listCustomer = customerService.findAll(pageable);
//        model.addAttribute("listCustomer", listCustomer);
//        return "/customer/list";
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showCreatePage() {
//        return new ModelAndView("/customer/create","customer", new Customer());
//    }
//
//    @PostMapping("/save")
//    public String createCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "/customer/create";
//        }
//        customerService.save(customer);
//        model.addAttribute("customer", new Customer());
//        model.addAttribute("success","New customer has been created !");
//        return "/customer/create";
//    }
//
//    @GetMapping("/view/{id}")
//    public ModelAndView showViewPage(@PathVariable Integer id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            return new ModelAndView("/customer/view", "customer", customer);
//        } else {
//            return new ModelAndView("home");
//        }
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditPage(@PathVariable Integer id) {
//        Customer customer = customerService.findById(id);
//        return new ModelAndView("/customer/edit", "customer", customer);
//    }
//
//    @PostMapping("/edit")
//    public String editCustomer(Customer customer, RedirectAttributes ra) {
//        customerService.save(customer);
//        ra.addFlashAttribute("success", "Customer has been updated !");
//        return "redirect:/customer";
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeletePage(@PathVariable Integer id) {
//        Customer customer = customerService.findById(id);
//        return new ModelAndView("/customer/delete", "customer", customer);
//    }
//
//    @PostMapping("/delete")
//    public String deleteBlog(Customer customer, RedirectAttributes ra, @RequestParam String submit) {
//        if (submit.equals("Delete")) {
//            customerService.remove(customer.getId());
//            ra.addFlashAttribute("success", "Customer has been deleted !");
//        }
//        return "redirect:/customer";
//    }

}

