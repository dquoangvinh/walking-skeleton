package com.example.catalog.service;

import com.example.catalog.dto.ProductSummary;
import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductSummary> getProducts(boolean withReviews) {
        List<Product> products = withReviews
                ? productRepository.findAllWithReviews()
                : productRepository.findAll();
        return products.stream()
                .map(p -> new ProductSummary(p.getId(), p.getName(),
                        withReviews ? p.getReviews().size() : null))
                .toList();
    }
}
