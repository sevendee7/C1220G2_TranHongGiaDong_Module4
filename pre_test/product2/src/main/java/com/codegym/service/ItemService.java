package com.codegym.service;

import com.codegym.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    List<Item> findTop5();

    void save(Item item);
}
