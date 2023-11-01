package com.br.pan.service;

import java.util.List;

import com.br.pan.model.ProductCustomer;

public interface ProductCustomerService {
    
    public ProductCustomer save(ProductCustomer product);

    public void delete(ProductCustomer product)throws Exception;

    public List<ProductCustomer> search(String CPFCustomer)throws Exception;
}
