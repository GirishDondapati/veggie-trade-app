package com.veggietrade.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veggietrade.model.Product;
import com.veggietrade.service.ProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product(1L, "Tomatoes", "Fresh Organic red tomatoes", 40.0);
        when(productService.saveProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Tomatoes"))
                .andExpect(jsonPath("$.description").value("Fresh Organic red tomatoes"))
                .andExpect(jsonPath("$.price").value(40.0));

        verify(productService, times(1)).saveProduct(any(Product.class));
    }

   /*@Test
    void testGetAllProducts() throws Exception {
        Product product1 = new Product(1L, "Apple", "Fresh Organic red apple", 10.5);
        Product product2 = new Product(2L, "Banana", "Fresh banana", 5.0);
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[1].name").value("Banana"));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product(1L, "Apple", "Fresh Organic red apple", 10.5);
        when(productService.getProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Apple"))
                .andExpect(jsonPath("$.description").value("Fresh Organic red apple"))
                .andExpect(jsonPath("$.price").value(10.5));

        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());

        verify(productService, times(1)).deleteProduct(1L);
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product updatedProduct = new Product(1L, "Updated Apple", "Fresh Organic red apple", 12.0);
        when(productService.updateProduct(any(Product.class), eq(1L))).thenReturn(updatedProduct);

        mockMvc.perform(put("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Updated Apple"))
                .andExpect(jsonPath("$.description").value("Fresh Organic red apple"))
                .andExpect(jsonPath("$.price").value(12.0));

        verify(productService, times(1)).updateProduct(any(Product.class), eq(1L));
    }*/
}