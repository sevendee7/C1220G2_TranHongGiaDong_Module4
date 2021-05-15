package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.entity.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product_detail.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductDetailService productDetailService;

    @GetMapping("/category")
    public ModelAndView listCategory(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("/home_category","categories",categoryService.findAll(pageable));
    }

    @GetMapping("/create-category")
    public ModelAndView createPage() {
        return new ModelAndView("/category/create","category",new Category());
    }

    @PostMapping("/save-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        modelAndView.addObject("message","New category has been created !");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView editPage(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/edit","category",category);
    }

    @PostMapping("/edit-category")
    public String updateCategory(RedirectAttributes redirectAttributes, Category category) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","Category has been updated !");
        return "redirect:/category";
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView deletePage(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/delete","category",category);
    }

    @PostMapping("/delete-category")
    public String deleteCategory(Category category, @RequestParam String submit, RedirectAttributes redirectAttributes) {
        if (submit.equals("Delete")) {
            categoryService.remove(category.getId());
            redirectAttributes.addFlashAttribute("message","Category has been deleted !");
        }
        return "redirect:/category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id, Pageable pageable) {
        Category category = categoryService.findById(id);
        Page<Product> products = productService.findAllByCategory(category,pageable);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category",category);
        modelAndView.addObject("listProduct",products);
        return modelAndView;
    }
}
