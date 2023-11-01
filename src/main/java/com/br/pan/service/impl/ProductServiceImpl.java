package com.br.pan.service.impl;

import com.br.pan.model.Product;
import com.br.pan.repository.ProductRepository;
import com.br.pan.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductServiceImpl implements ProductService {
   
    Logger logger = LoggerFactory.getLogger( ProductServiceImpl.class);

    @Autowired
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

}
