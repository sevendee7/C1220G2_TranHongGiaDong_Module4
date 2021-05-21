package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    private static int quantity = 2;
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll(2);
    }

    @GetMapping
    public ModelAndView showPage() {
        return new ModelAndView("/home", "blogs", blogService.findAll(2));
    }

    @GetMapping("/more-blog")
    public ModelAndView getMore(){
        quantity += 2;
        return new ModelAndView("/more","blogs",blogService.findAll(quantity));
    }

    @GetMapping("/search/{keyword}")
    public ModelAndView showSearchList(@PathVariable String keyword) {
        if ("".equals(keyword)) {
            return new ModelAndView("/search", "blogs", blogService.findAll(3));
        }
        return new ModelAndView("/search", "blogs", blogService.findAllByBlogName(keyword));

    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/save")
    public String createNewBlog(Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("success", "Created new blog successfully");
        return "/blog/create";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewPage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/view", "blog", blog);
        } else {
            return new ModelAndView("home");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/edit", "blog", blog);
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes ra) {
        blogService.save(blog);
        ra.addFlashAttribute("success", "Updated blog successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/delete", "blog", blog);
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes ra, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            blogService.remove(blog.getId());
            ra.addFlashAttribute("success", "Deleted blog successfully");
        }
        return "redirect:/";
    }
}
