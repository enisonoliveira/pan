package com.br.pan.controller;

import java.util.List;

import com.br.pan.model.Address;
import com.br.pan.model.City;
import com.br.pan.model.Customer;
import com.br.pan.model.State;
import com.br.pan.service.AddressService;
import com.br.pan.service.CityService;
import com.br.pan.service.CustomerService;
import com.br.pan.service.StateService;
import com.br.pan.vo.CustomerSaveParams;
import com.br.pan.vo.CustomerUpdateParams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    
    Logger logger = LoggerFactory.getLogger( CustomerController.class);

	@Autowired
	private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;
    

	@PostMapping(value = "/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody CustomerSaveParams customerRequest) throws Exception {

		logger.info("inserindo cliente"+customerRequest.getName());
		logger.info("inserindo endereço"+customerRequest.getAddress().getStreet());

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setCPF(customerRequest.getCPF());
		Address address = new Address();
        City city = new City();
		address.setStreet(customerRequest.getAddress().getStreet());
		address.setNeigborHood(customerRequest.getAddress().getNeigborHood());
		address.setZipCode(customerRequest.getAddress().getZipCode());
		address.setNumber(customerRequest.getAddress().getNumber());
        city.setName(customerRequest.getAddress().getNameCity());
        State state = new State();
        state.setUF(customerRequest.getAddress().getUF());
		address.setCity(city);
        address.getState().setName(customerRequest.getAddress().getState());
        cityService.save(city);
        stateService.save(state);
        address.setCity(city);
        address.setState(state);
        addressService.save(address);
        customer.setAddress(address);
		customerService.save(customer);
	
		return new ResponseEntity<String>("inserido id:" + customer.getId(), HttpStatus.CREATED);

	}

	@PutMapping(value = "/customer/edit/address", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody CustomerUpdateParams customerRequest) throws Exception {

		logger.info("editando endereço"+customerRequest.getAddress().getCity());

		Customer customer = new Customer();
		Address address = new Address();
        City city = new City();
		address.setStreet(customerRequest.getAddress().getStreet());
		address.setNeigborHood(customerRequest.getAddress().getNeigborHood());
		address.setZipCode(customerRequest.getAddress().getZipCode());
		address.setNumber(customerRequest.getAddress().getNumber());
        city.setName(customerRequest.getAddress().getNameCity());
        State state = new State();
        state.setUF(customerRequest.getAddress().getUF());
		address.setCity(city);
        address.getState().setName(customerRequest.getAddress().getState());
        cityService.save(city);
        stateService.save(state);
        address.setCity(city);
        address.setState(state);
        addressService.save(address);
        customer.setAddress(address);
		customerService.save(customer);
	
	    return new ResponseEntity<String>("editado idcustomer:" + customer.getId(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/customer/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> searchList(@PathVariable String CPF) throws Exception {

		customerService.delete(CPF);

		return new ResponseEntity<>("Deleted:"+CPF, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/searchAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> searchAll() {
	
		List<Customer> customerList = customerService.findAll();

		return customerList;
	}

	@RequestMapping(value = "/customer/searchOne", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Customer searchOne(@RequestBody CustomerSaveParams customerParams) {
		logger.info("buscando cliente"+customerParams.getCPF());

		Customer customerList = customerService.search(customerParams.getCPF());


		return customerList;
	}
}
