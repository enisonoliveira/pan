package com.br.pan.service;

import java.util.List;

import com.br.pan.model.Customer;

public interface CustomerService {
    

    public Customer save(Customer customerDTO ) throws Exception;

    public Customer update(Customer customerDTO );

    public Customer search(String CPF );

    public void delete(String CPF ) throws Exception;

    public List<Customer> findAll();
}
