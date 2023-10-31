package com.br.pan.service;

import com.br.pan.model.Customer;

public interface CustomerService {
    

    public Customer save(Customer customerDTO );

    public Customer update(Customer customerDTO );

    public Customer search(String CPF );

    public void delete(Customer customerDTO );
}
