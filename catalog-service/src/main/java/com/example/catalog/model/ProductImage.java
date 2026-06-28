package com.example.catalog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String url;

    protected ProductImage() {}

    public Product getProduct() {
        return product;
    }

    public String getUrl() {
        return url;
    }
}
