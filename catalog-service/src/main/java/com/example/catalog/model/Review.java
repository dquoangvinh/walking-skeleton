package com.example.catalog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int rating;
    private String content;

    protected Review() {}

    public Product getProduct() {
        return product;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }
}
