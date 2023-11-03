package com.br.pan.service.impl;

import java.util.List;

import com.br.pan.model.Customer;
import com.br.pan.repository.CustomerRepository;
import com.br.pan.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl  implements CustomerService{

    Logger logger = LoggerFactory.getLogger( CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;

    /*
    *@see  public Customer save(Customer customerDTO)
    */
    @Override
    public Customer save(Customer customerDTO) throws Exception {
        logger.info("====salvando no bd o cliente====");
        if(search(customerDTO.getCPF())!=null){
            logger.warn("CPF já existe "+ customerDTO.getCPF());
            return customerDTO;
        }else{
            if(customerDTO.getCPF().length()!=11){
                logger.error("CPF esta incorreto "+customerDTO.getCPF().length());   
                throw new Exception("CPF esta incorreto");
            }
        }
        return customerRepository.save(customerDTO);
    }

    /*
    *@see  public Customer update(Customer customerDTO) 
    */
    @Override
    public Customer update(Customer customerDTO) {
        logger.info("====aterando no bd o cliente====");
        return customerRepository.save(customerDTO);
    }

    /*
    *@see  public Customer search(String CPF)
    */
    @Override
    public Customer search(String CPF) {
        logger.info("====procurando no bd o cliente====");
        return customerRepository.search(CPF);
    }

    /*
    *@see  public void delete(String CPF) 
    */
    @Override
    public void delete(String CPF) throws Exception {
        logger.info("====delete no bd o cliente====");
        if( search(CPF)==null ){
            logger.error("CPF informado não existe no banco"+ CPF);
            throw new Exception("CPF informado não existe");
        }
        customerRepository.delete(CPF);
        
    }

    /*
    *@see   public List<Customer> findAll()
    */
    @Override
    @Cacheable(value = "_methods")
    public List<Customer> findAll() {
        logger.info("listando todos os clientes");
        return customerRepository.findAll();
    }
    
}
