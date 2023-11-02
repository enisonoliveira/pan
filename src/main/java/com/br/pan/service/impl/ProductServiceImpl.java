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

    /*
    *@see  public Product save(Product productDTO) 
    */
    @Override
    public Product save(Product productDTO) {
        logger.info("====salvando os dados do produto====");
        return productRepository.save(productDTO);
    }

    /*
    *@see  public Product update(Product productDTO)
    */
    @Override
    public Product update(Product productDTO) {
        logger.info("====alterando os dados do produto====");
        return productRepository.save(productDTO);
    }

    /*
    *@see  public void delete(Product productDTO) 
    */
    @Override
    public void delete(Product productDTO) {
        logger.info("====deletando o produto:"+ productDTO.getName());
         productRepository.delete(productDTO);
        
    }

}
