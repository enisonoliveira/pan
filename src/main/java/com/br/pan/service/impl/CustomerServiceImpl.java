package com.br.pan.service.impl;

import java.util.List;

import com.br.pan.model.Customer;
import com.br.pan.repository.CustomerRepository;
import com.br.pan.service.CustomerService;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService{

    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customerDTO) {
        return customerRepository.save(customerDTO);
    }

    @Override
    public Customer update(Customer customerDTO) {
        return customerRepository.save(customerDTO);
    }

    @Override
    public Customer search(String CPF) {
        return customerRepository.search(CPF);
    }


    @Override
    public void delete(String CPF) {
        customerRepository.delete(CPF);
        
    }

    @Override
    public List<Customer> findAll() {
       
        return customerRepository.findAll();
    }
    
}
