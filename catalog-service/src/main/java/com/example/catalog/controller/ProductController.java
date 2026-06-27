package com.example.catalog.controller;

import com.example.catalog.dto.ProductSummary;
import com.example.catalog.service.ProductService;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "api/v1/products")
    public List<ProductSummary> getProducts(
            @RequestParam(required = false)
            @Pattern(regexp = "reviews", message = "include only supports 'reviews'")
            String include) {
        boolean withReviews = "reviews".equals(include);
        return productService.getProducts(withReviews);
    }
}
