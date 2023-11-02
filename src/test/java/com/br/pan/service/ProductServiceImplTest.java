package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.pan.model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceImplTest {
    
    @Autowired
    private ProductService productService;

    @Test
    @BeforeEach
    void saveProductTest() throws Exception {
        Product productDTO = new Product();
        productDTO.setName("cartao");
        Product product=  productService.save(productDTO);
        assertEquals(product.getName(),productDTO.getName());                                        
    }

    @Test
    @BeforeEach
    void updateProductTest() throws Exception {
        Product productDTO = new Product();
        productDTO.setName("cartao");
        productDTO.setId(1L);
        Product product=  productService.save(productDTO);
        assertEquals(product.getName(),productDTO.getName());                                        
    }

}
