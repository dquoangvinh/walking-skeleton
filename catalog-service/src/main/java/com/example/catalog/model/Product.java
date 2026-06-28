package com.example.catalog.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> images = new LinkedHashSet<>();

    public Set<Review> getReviews() {
        return reviews;
    }

    public Set<ProductImage> getImages() {
        return images;
    }

    protected Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}