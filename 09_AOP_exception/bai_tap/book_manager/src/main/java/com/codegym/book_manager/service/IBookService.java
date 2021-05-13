package com.codegym.book_manager.service;

import com.codegym.book_manager.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);

    void deleteById(Integer id);

    Book findById(Integer id);

    List<Book> findAll();
}
