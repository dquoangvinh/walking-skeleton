package com.example.catalog.controller;

import com.example.catalog.dto.ProductSummary;
import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "api/v1/products")
    public List<ProductSummary> getProducts(@RequestParam(required = false) String include) {
        boolean withReviews = "reviews".equals(include);
        List<Product> products = withReviews
                ? productRepository.findAllWithReviews()
                : productRepository.findAll();
        return products.stream()
                .map(p -> new ProductSummary(p.getId(), p.getName(),
                               withReviews ? p.getReviews().size() : null))
                .toList();
    }
}
