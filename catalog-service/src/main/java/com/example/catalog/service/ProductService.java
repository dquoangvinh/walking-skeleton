package com.example.catalog.service;

import com.example.catalog.dto.ProductSummary;
import com.example.catalog.model.Product;
import com.example.catalog.model.ProductImage;
import com.example.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductSummary> getProducts(Set<String> include) {
        boolean withReviews = include.contains("reviews");
        boolean withImages = include.contains("images");

        List<Product> products;
        if (withReviews && withImages) {
            products = productRepository.findAllWithReviewAndImages();
        } else if (withImages) {
            products = productRepository.findAllWithImages();
        } else if (withReviews) {
            products = productRepository.findAllWithReviews();
        } else {
            products = productRepository.findAll();
        }

        return products.stream()
                .map(p -> new ProductSummary(
                        p.getId(),
                        p.getName(),
                        withReviews ? p.getReviews().size() : null,
                        withImages ? firstImageUrl(p) : null))
                .toList();
    }

    private String firstImageUrl(Product p) {
        return p.getImages().stream().findFirst().map(ProductImage::getUrl).orElse(null);
    }
}
