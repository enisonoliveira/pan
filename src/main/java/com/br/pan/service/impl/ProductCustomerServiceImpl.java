package com.br.pan.service.impl;

import java.util.List;

import com.br.pan.model.ProductCustomer;
import com.br.pan.repository.ProductCustomerRepository;
import com.br.pan.service.ProductCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomerServiceImpl implements ProductCustomerService {

    @Autowired
    private ProductCustomerRepository productCustomerRepository;
    @Override
    public ProductCustomer save(ProductCustomer product) {
        return productCustomerRepository.save(product);
    }

    @Override
    public void delete(ProductCustomer product) {
        productCustomerRepository.delete(product);
    }

    @Override
    public List<ProductCustomer> search(String CPFCustomer) {
        return productCustomerRepository.search(CPFCustomer);
    }
    
}
