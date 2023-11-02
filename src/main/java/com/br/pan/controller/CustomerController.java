package com.br.pan.controller;

import java.util.List;

import com.br.pan.model.Address;
import com.br.pan.model.Location;
import com.br.pan.model.Customer;
import com.br.pan.model.State;
import com.br.pan.service.AddressService;
import com.br.pan.service.LocationService;
import com.br.pan.service.CustomerService;
import com.br.pan.service.StateService;
import com.br.pan.vo.ClienteRequestSave;
import com.br.pan.vo.ClienteRequestUpdate;

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
    private LocationService cityService;
    @Autowired
    private StateService stateService;
    

	@PostMapping(value = "/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody ClienteRequestSave customerRequest) throws Exception {

		logger.info("inserindo cliente"+customerRequest.getNome());

		Customer customer = new Customer();
		customer.setName(customerRequest.getNome());
		customer.setCPF(customerRequest.getCPF());
		
		Address address = addressService.search(customerRequest.getAddress().getCep());        
		
		Location city = new Location();
		
		address.setNumber(customerRequest.getAddress().getNumero());

        State state = stateService.searchExternal(customerRequest.getAddress().getUf());
		state= stateService.save(state);

		city.setState(state);
		city=cityService.searchExternal(customerRequest.getAddress().getNumeroIBGEMunicipio());
		city=cityService.save(city);

		address.setCity(city);
		address.setZipCode(customerRequest.getAddress().getCep());
        address.setState(state);
		address= addressService.save(address);

        customer.setAddress(address);
		customerService.save(customer);
	
		return new ResponseEntity<String>("inserido id:" + customer.getId(), HttpStatus.CREATED);

	}

	@PutMapping(value = "/customer/edit/address", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody ClienteRequestUpdate customerRequest) throws Exception {
		
		Address oldAddress = addressService.searchAddresCPF(customerRequest.getCPF());

		Address address = addressService.search(customerRequest.getAddress().getCep());        
		address.setId(oldAddress.getId());

		Location city = new Location();
		city=cityService.searchExternal(customerRequest.getAddress().getNumeroIBGEMunicipio());
		
		address.setNumber(customerRequest.getAddress().getNumero());
        
		State state = stateService.searchExternal(customerRequest.getAddress().getUf());
		state= stateService.save(state);
		
		city.setState(state);
		city=cityService.save(city);

		address.setCity(city);
        address.setState(state);
		address= addressService.update(address);
	
	    return new ResponseEntity<String>("editado endereço:" + address.getNeigborHood(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/customer/delete/{CPF}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> searchDel(@PathVariable String CPF) throws Exception {

		customerService.delete(CPF);

		return new ResponseEntity<>("Deleted:"+CPF, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/searchAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> searchAll() {
		List<Customer> customerList = customerService.findAll();
		return customerList;
	}

	@RequestMapping(value = "/customer/search/{CPF}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Customer searchCPF(@PathVariable String CPF) {
		logger.info("buscando cliente"+CPF);
		Customer customerList = customerService.search(CPF);
		return customerList;
	}
}
