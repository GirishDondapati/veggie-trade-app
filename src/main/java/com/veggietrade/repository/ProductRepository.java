package com.veggietrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veggietrade.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom queries here if needed
}