package com.example.catalog.controller;

import com.example.catalog.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @GetMapping("api/v1/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1, "test"),
                new Product(2, "iPhone 17 Pro")
        );
    }
}
