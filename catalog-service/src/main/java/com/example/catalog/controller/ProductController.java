package com.example.catalog.controller;

import com.example.catalog.dto.ProductSummary;
import com.example.catalog.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "api/v1/products")
    public List<ProductSummary> getProducts(@RequestParam(required = false) Set<String> include) {
        return productService.getProducts(include == null ? Set.of() : include);
    }
}
