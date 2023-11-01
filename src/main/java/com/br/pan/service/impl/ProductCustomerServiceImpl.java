package com.br.pan.service.impl;

import java.util.List;

import com.br.pan.model.ProductCustomer;
import com.br.pan.repository.ProductCustomerRepository;
import com.br.pan.service.ProductCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductCustomerServiceImpl implements ProductCustomerService {

    Logger logger = LoggerFactory.getLogger( ProductCustomerServiceImpl.class);

    @Autowired
    private ProductCustomerRepository productCustomerRepository;
    @Override
    public ProductCustomer save(ProductCustomer product) {
        return productCustomerRepository.save(product);
    }

    @Override
    public void delete(ProductCustomer product) throws Exception {
        if(productCustomerRepository.existsById( product.getId())){
            throw new Exception("Id de Municipio não informado");
        }
        productCustomerRepository.delete(product);
    }

    @Override
    public List<ProductCustomer> search(String CPFCustomer) throws Exception {
        List<ProductCustomer> list= productCustomerRepository.search(CPFCustomer);
        if( list==null ){
            throw new Exception("Não encontrado");
        }
        return list;
    }
    
}
