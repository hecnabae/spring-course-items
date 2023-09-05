package com.mesquedades.item.models.service.impl;

import com.mesquedades.item.models.dto.Item;
import com.mesquedades.item.models.dto.Product;
import com.mesquedades.item.models.service.contract.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    // Cliente Rest ha sido definido en AppConfig.java
    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(clienteRest.getForObject("http://localhost:8001/products", Product[].class));
        List<Item> items = products.stream().map(p -> {
            Item item = new Item(p, 1);
            return item;
        }).collect(Collectors.toList());
        return items;
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = clienteRest.getForObject("http://localhost:8001/products/{id}", Product.class, pathVariables);
        Item item = new Item(product, quantity);
        return item;
    }
}
