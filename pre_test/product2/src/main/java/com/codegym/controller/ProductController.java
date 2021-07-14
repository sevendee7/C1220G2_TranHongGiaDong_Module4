package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICategoryService;
import com.codegym.service.IColorService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private final IProductService productService;
    private final IColorService colorService;
    private final ICategoryService categoryService;

    @Autowired
    public ProductController(IProductService productService, IColorService colorService, ICategoryService categoryService) {
        this.productService = productService;
        this.colorService = colorService;
        this.categoryService = categoryService;
    }

    @ModelAttribute
    public void getExtraDetails(Model model) {
        model.addAttribute("colors", colorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
    }

    @GetMapping("/search-top-5")
    public ModelAndView searchTop5() {
        return new ModelAndView("/product/top5","products",productService.findTop5());
    }


    @GetMapping("/page/{pageNum}")
    public String showHomePage(Model model,
                               @PathVariable("pageNum") int currentPage,
                               @Param("sortField") String sortField,
                               @Param("sortDir") String sortDir,
                               @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "brand", required = false) String brand,
                               @RequestParam(value = "categoryName", required = false) String categoryName) {
        Page<Product> page = productService.findAfterSearch(currentPage, sortField, sortDir, name, brand, categoryName);
        List<Product> productList = page.getContent();
        model.addAttribute("products",productList);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("name",name);
        model.addAttribute("brand",brand);
        model.addAttribute("categoryName",categoryName);
        return "/home";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        String name = null;
        String brand = null;
        String categoryName = null;
        return showHomePage(model,1,"id","asc",name,brand,categoryName);
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("product/create","product", new Product());
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        model.addAttribute("success","Product has been created !");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        return new ModelAndView("/product/edit","product", productService.findById(id));
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes ra) {
        productService.save(product);
        ra.addFlashAttribute("success","Product has been updated");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable Integer id) {
        return new ModelAndView("/product/delete","product", productService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes ra, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            productService.delete(product.getId());
            ra.addFlashAttribute("success", "Employee has been deleted !");
        }
        return "redirect:/";
    }
}
