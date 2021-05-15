package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.entity.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product_detail.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductDetailService productDetailService;

    @ModelAttribute("categories")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/product")
    public ModelAndView listProduct(@SortDefault(sort = "name", direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("home_product", "products", productService.findAll(pageable));
    }

    @GetMapping("/create-product")
    public ModelAndView createPage() {
        return new ModelAndView("/product/create", "product", new Product());
    }

    @PostMapping("/save-product")
    public String savePage(Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", new Product());
        model.addAttribute("message", "New product has been saved !");
        return "/product/create";
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ModelAndView("/product/view", "product", product);
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView editPage(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ModelAndView("/product/edit","product",product);
    }

    @PostMapping("/edit-product")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Product updated !");
        return "redirect:/product";
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView deletePage(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ModelAndView("/product/delete","product",product);
    }

    @PostMapping("/delete-product")
    public String deleteProduct(Product product, @RequestParam String submit, RedirectAttributes redirectAttributes) {
        if (submit.equals("Delete")) {
            productService.remove(product.getId());
            redirectAttributes.addFlashAttribute("message","Product has been deleted !");
        }
        return "redirect:/product";
    }
}
