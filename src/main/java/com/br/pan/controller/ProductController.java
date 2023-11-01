package com.br.pan.controller;

import com.br.pan.model.Customer;
import com.br.pan.model.Product;
import com.br.pan.service.CustomerService;
import com.br.pan.service.ProductService;
import com.br.pan.vo.ProductCustomerParams;
import com.br.pan.vo.ProductParamter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {
 
    Logger logger = LoggerFactory.getLogger( ProductController.class);
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody ProductCustomerParams customerRequest) throws Exception {
        
        Product productDTO = new Product();
        productDTO.setName(customerRequest.getProducName());
        productService.save(productDTO);
        return new ResponseEntity<String>("inserido id:" + productDTO.getId(), HttpStatus.CREATED);

    }


    @PutMapping(value = "/product/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@RequestBody ProductCustomerParams customerRequest) throws Exception {
        return null;
    }
}
