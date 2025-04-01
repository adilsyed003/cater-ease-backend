package com.catering.mongo.controller;

import com.catering.mongo.model.Item;
import com.catering.mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return repository.findById(String.valueOf(id));
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repository.save(item);
    }
}