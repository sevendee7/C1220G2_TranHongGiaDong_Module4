package com.codegym.book_manager.controller;

import com.codegym.book_manager.entity.Book;
import com.codegym.book_manager.entity.CustomerCode;
import com.codegym.book_manager.exception.OutOfStockException;
import com.codegym.book_manager.exception.WrongCodeException;
import com.codegym.book_manager.service.IBookService;
import com.codegym.book_manager.service.ICustomerCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerCodeController {
    @Autowired
    IBookService bookService;

    @Autowired
    ICustomerCodeService customerCodeService;

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("/rent")
    public ModelAndView listBook() {
        return new ModelAndView("rent","books",bookService.findAll());
    }

    @GetMapping("/return")
    public ModelAndView returnBook() {
        return new ModelAndView("/return","customerCode",new CustomerCode());
    }

    @GetMapping("/{id}/rent")
    public String rentBook(@PathVariable Integer id, Model model) throws OutOfStockException {
        Book book = bookService.findById(id);
        Integer quantity = book.getQuantity();
        if (quantity == 0) {
            throw new OutOfStockException();
        }
        book.setQuantity(quantity - 1);
        bookService.save(book);
        int randomCode = (int) Math.floor(((Math.random() * 1234) + 1000));
        String rentCode = String.valueOf(randomCode);
        model.addAttribute("rentCode",rentCode);
        CustomerCode customerCode = new CustomerCode();
        customerCode.setCodeForBook(rentCode);
        customerCode.setBook(book);
        customerCodeService.save(customerCode);
        return "home";
    }

    @ExceptionHandler(OutOfStockException.class)
    public String outOfStock() {
        return "out_of_stock";
    }

    @PostMapping("/return-book")
    public String returnBook(CustomerCode customerCode, Model model) throws WrongCodeException {
        CustomerCode rentCode = customerCodeService.findByCode(customerCode.getCodeForBook());
        if (rentCode == null) {
            throw new WrongCodeException();
        }
        Book book = rentCode.getBook();
        Integer quantity = book.getQuantity();
        book.setQuantity(quantity + 1);
        bookService.save(book);
        customerCodeService.delete(rentCode.getId());
        model.addAttribute("message","Return book success");
        return "home";
    }

    @ExceptionHandler(WrongCodeException.class)
    public String wrongCode() {
        return "wrong_code";
    }
}
