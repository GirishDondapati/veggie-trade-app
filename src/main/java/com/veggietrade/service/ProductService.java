package com.veggietrade.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veggietrade.model.Product;
import com.veggietrade.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
   public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Delete a product by ID
   public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Update Product
    @Transactional
    public Product updateProduct(Product newProductData, Long id) {

        return productRepository.findById(id).map(product -> {
            product.setName(newProductData.getName());
            product.setDescription(newProductData.getDescription());
            product.setPrice(newProductData.getPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));        
    }

   public String getAllProducts1() {
        return "Working as expected";
    }
}