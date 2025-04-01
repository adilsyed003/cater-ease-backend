package com.catering.mongo.controller;

import com.catering.mongo.model.Item;
import com.catering.mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")  // Allows React frontend to access this API
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repository.save(item);
    }
}