package com.codegym.controller;

import com.codegym.model.Discount;
import com.codegym.repository.IDiscountRepository;
import com.codegym.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DiscountController {

    private final IDiscountService discountService;

    @Autowired
    public DiscountController(IDiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ModelAndView showHomePage(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("/list", "discounts", discountService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/create", "discount", new Discount());
    }

    @PostMapping("/save")
    public String saveProduct(@Validated Discount discount, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        discountService.save(discount);
        model.addAttribute("discount", new Discount());
        model.addAttribute("success", "Discount has been created !");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable Integer id) {
        Discount discount = discountService.findById(id);
        return new ModelAndView("/delete", "discount", discount);
    }

    @PostMapping("/delete")
    public String deleteDiscount(Discount discount, RedirectAttributes ra, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            discountService.deleteById(discount.getId());
            ra.addFlashAttribute("success", "Discount has been deleted !");
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String showSearchList(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "amount") String amount, Model model) {
        if (amount != null) {
            Page<Discount> listDiscount = discountService.findDiscountByAmount(amount, pageable);
            model.addAttribute("listDiscount", listDiscount);
            model.addAttribute("amount", amount);
            return "/search";
        }
        model.addAttribute("discounts", discountService.findAll(pageable));
        return "/list";
    }
}
