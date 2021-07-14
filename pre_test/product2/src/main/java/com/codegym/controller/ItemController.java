package com.codegym.controller;

import com.codegym.model.Item;
import com.codegym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/top5item")
    public ModelAndView top5() {
        return new ModelAndView("/top5item","items",itemService.findTop5());
    }

    @GetMapping("/item")
    public ModelAndView showList() {
        return new ModelAndView("/item","items",itemService.findAll());
    }

    @GetMapping("/create-item")
    public ModelAndView create() {
        return new ModelAndView("/create","item",new Item());
    }

    @PostMapping("/save-item")
    public String saveItem(Item item) {
        itemService.save(item);
        return "redirect:/create-item";
    }
}
