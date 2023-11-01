package com.br.pan.controller;

import java.util.List;

import com.br.pan.model.Customer;
import com.br.pan.model.Product;
import com.br.pan.model.ProductCustomer;
import com.br.pan.service.ProductCustomerService;
import com.br.pan.vo.ProdutoClienteRequestResponse;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductCustomerController {

    Logger logger = LoggerFactory.getLogger( ProductController.class);
   
    @Autowired
    private ProductCustomerService productCustomerService;

    @PostMapping(value = "/product/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveProductCustomer(@RequestBody ProdutoClienteRequestResponse customerRequest) throws Exception {
        
        Product productDTO = new Product();
        Customer customer = new Customer();
        ProductCustomer productCustomer = new ProductCustomer();
        customer.setId(customerRequest.getCustomerId());
        productDTO.setId(customerRequest.getProducId());
        productCustomer.setProduct(productDTO);
        productCustomer.setCustomer(customer);
        productCustomerService.save(productCustomer);
        return new ResponseEntity<String>("inserido id:" + productDTO.getId(), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/product/customer/search/{CPF}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductCustomer> searchCity(@PathVariable String CPF) throws Exception {
        return productCustomerService.search(CPF);
    }
}
