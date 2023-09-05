package com.mesquedades.item.controllers;

import com.mesquedades.item.models.dto.Item;
import com.mesquedades.item.models.service.contract.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}/quantity/{quantity}")
    public Item findById(@PathVariable Long id, @PathVariable Integer quantity) {
        return itemService.findById(id, quantity);
    }
}
