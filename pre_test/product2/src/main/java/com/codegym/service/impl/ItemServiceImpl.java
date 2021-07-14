package com.codegym.service.impl;

import com.codegym.model.Item;
import com.codegym.repository.ItemRepository;
import com.codegym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findTop5() {
        return itemRepository.findTop5ByOrderByPublishDateDesc();
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }
}
