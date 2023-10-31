package com.br.pan.service;

import java.util.List;

import com.br.pan.model.ProductCustomer;

public interface ProductCustomerService {
    
    public ProductCustomer save(ProductCustomer product);

    public void delete(ProductCustomer product);

    public List<ProductCustomer> search(String CPFCustomer);
}
