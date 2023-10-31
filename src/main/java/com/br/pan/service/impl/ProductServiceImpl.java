package com.br.pan.service.impl;

import java.util.List;

import com.br.pan.model.Product;
import com.br.pan.repository.ProductRepository;
import com.br.pan.service.ProductService;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private  ProductRepository productRepository;

    @Override
    public Product save(Product productDTO) {
        return productRepository.save(productDTO);
    }

    @Override
    public Product update(Product productDTO) {
        return productRepository.save(productDTO);
    }

    @Override
    public void delete(Product productDTO) {
         productRepository.delete(productDTO);
        
    }

    @Override
    public List<Product> search(String CPF) {
        return productRepository.search(CPF);
    }
    
}
