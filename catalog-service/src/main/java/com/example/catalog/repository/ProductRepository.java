package com.example.catalog.repository;

import com.example.catalog.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = "reviews")
    @Query("SELECT p FROM Product p")
    List<Product> findAllWithReviews();
}
