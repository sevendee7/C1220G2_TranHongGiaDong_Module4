package com.codegym.demo.controller;

import com.codegym.demo.entity.Blog;
import com.codegym.demo.entity.Category;
import com.codegym.demo.service.blog.IBlogService;
import com.codegym.demo.service.category.ICategoryService;
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
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showPage(@SortDefault(sort = "blogName", direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable, @RequestParam String search) {
        if (search != null) {
            if (blogService.findAllByBlogName(search, pageable) != null) {
                return new ModelAndView("/home", "blogs", blogService.findAllByBlogName(search, pageable));
            } else {
                return new ModelAndView("/error");
            }
        } else {
            if (blogService.findAll(pageable) != null) {
                return new ModelAndView("/home", "blogs", blogService.findAll(pageable));
            } else {
                return new ModelAndView("/error");
            }
        }
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
