package com.mesquedades.item.models.service.contract;

import com.mesquedades.item.models.dto.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();

    public Item findById(Long id, Integer quantity);
}
