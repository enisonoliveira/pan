package com.br.pan.service;

import com.br.pan.model.Address;
import com.br.pan.model.City;
import com.br.pan.model.Customer;
import com.br.pan.model.State; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceImpl {
    

    @Autowired
	private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;

    @Test
    @BeforeEach
    void saveCutomerTest() throws Exception{
        Address addressDTO = new Address();
        City city = new City();
        city.setName("Sorocaba");
        city.setNumero("22");

        State state = new State();
        state.setName("São Paulo");
        state.setUF("SP");
        state=stateService.save(state);

        city.setState(state);
        city=cityService.save(city);
        
        addressDTO.setCity(city);
        addressDTO.setState(state);
        addressDTO.setNeigborHood("Sorocaba Parck");
        addressDTO.setStreet("Luiz asspo");
        addressDTO.setZipCode("18070090");

        addressDTO=addressService.save(addressDTO);


        Customer customerDTO  = new Customer ();
        customerDTO.setCPF("12312312");
        customerDTO.setName("Es");
        customerDTO.setId(1L);
        customerDTO.setAddress(addressDTO);
        customerService.save(customerDTO);
    }



    @Test
    void CutomerUpdateTest() throws Exception{
        Address addressDTO = new Address();
        City city = new City();
        city.setName("Sorocaba");
        city.setNumero("22");

        State state = new State();
        state.setName("São Paulo");
        state.setUF("SP");
        state=stateService.save(state);

        city.setState(state);
        city=cityService.save(city);
        
        addressDTO.setCity(city);
        addressDTO.setState(state);
        addressDTO.setNeigborHood("Sorocaba Parck");
        addressDTO.setStreet("Luiz asspo");
        addressDTO.setZipCode("18070090");

        addressDTO=addressService.save(addressDTO);


        Customer customerDTO  = new Customer ();
        customerDTO.setCPF("12312312");
        customerDTO.setName("Es");
        customerDTO.setId(1L);
        customerDTO.setAddress(addressDTO);
        customerService.update(customerDTO);
    }
}
