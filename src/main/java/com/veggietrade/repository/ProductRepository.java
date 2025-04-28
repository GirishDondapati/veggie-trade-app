package com.veggietrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veggietrade.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom queries here if needed
}