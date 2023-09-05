package com.mesquedades.item.models.dto;

import com.mesquedades.item.models.dto.Product;

import java.io.Serializable;

public class Item implements Serializable {
    private Product product;
    private Integer qty;

    public Item() {
    }

    public Item(Product product, Integer qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return product.getPrice() * qty.doubleValue();
    }
}
