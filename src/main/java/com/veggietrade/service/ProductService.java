package com.veggietrade.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veggietrade.model.Product;
import com.veggietrade.repository.ProductRepository;

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
    public Product updateProduct(Product product, Long id) {

 
        Product productFromDB  = productRepository.findById(id).get();
         productFromDB.setName(product.getName());
         productFromDB.setDescription(product.getDescription());
         productFromDB.setPrice(product.getPrice());
         
       /* if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            productFromDB.setName(product.getName());
        }
        if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
            productFromDB.setDescription(product.getDescription());
        }
        if (Objects.nonNull(product.getPrice()) && !"".equalsIgnoreCase(product.getPrice())) {
            productFromDB.setPrice(product.getPrice());
        }*/
 
        return productRepository.save(productFromDB);
    }

   public String getAllProducts1() {
        return "Working as expected";
    }
}