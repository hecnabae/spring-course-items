package com.mesquedades.item.clients;

import com.mesquedades.item.models.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-products", url = "localhost:8001")
public interface ProductRestClient {
    @GetMapping("/products")
    public List<Product> findAll();

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id);
}
