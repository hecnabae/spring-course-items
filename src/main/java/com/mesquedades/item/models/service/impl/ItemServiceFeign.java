package com.mesquedades.item.models.service.impl;

import com.mesquedades.item.clients.ProductRestClient;
import com.mesquedades.item.models.dto.Item;
import com.mesquedades.item.models.dto.Product;
import com.mesquedades.item.models.service.contract.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemServiceFeign implements ItemService {
    @Autowired
    private ProductRestClient productRestClient;

    @Override
    public List<Item> findAll() {
        List<Product> products = productRestClient.findAll();
        List<Item> items = products.stream().map(p -> {
            Item item = new Item(p, 1);
            return item;
        }).collect(Collectors.toList());
        return items;
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Product product = productRestClient.findById(id);
        Item item = new Item(product, quantity);
        return item;
    }
}
