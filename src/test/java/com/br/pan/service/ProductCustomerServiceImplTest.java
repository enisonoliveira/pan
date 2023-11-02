package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.br.pan.model.Address;
import com.br.pan.model.Location;
import com.br.pan.model.Customer;
import com.br.pan.model.Product;
import com.br.pan.model.ProductCustomer;
import com.br.pan.model.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductCustomerServiceImplTest {
    
    @Autowired
    private ProductCustomerService productCustomerService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private LocationService cityService;
    @Autowired
    private StateService stateService;
    @Autowired
    private ProductService productService;

    @Test
    @BeforeEach
    void saveProductCustomer() throws Exception{
        
        ProductCustomer productCustomerDTO = new ProductCustomer();
       
        Product productDTO = new Product();
        productDTO.setName("cartao");
        productDTO.setId(1L);
        Address addressDTO = new Address();
        Location city = new Location();
        city.setName("Sorocaba");
        city.setNumero("22");

        State state = new State();
        state.setName("São Paulo");
        state.setUF("SP");
        state = stateService.save(state);
        city.setId(1L);
        city.setState(state);
        city = cityService.save(city);

        addressDTO.setCity(city);
        addressDTO.setState(state);
        addressDTO.setNeigborHood("Sorocaba Parck");
        addressDTO.setStreet("Luiz asspo");
        addressDTO.setZipCode("18070090");

        addressDTO = addressService.save(addressDTO);

        Customer customerDTO = new Customer();
        customerDTO.setCPF("38106405700");
        customerDTO.setName("Es");
        customerDTO.setId(1L);
        customerDTO.setAddress(addressDTO);

        Customer customer = customerService.save(customerDTO);

        productCustomerDTO.setCustomer(customer);
        Product product=  productService.save(productDTO);
        productCustomerDTO.setProduct(product);
        ProductCustomer productCustomer =productCustomerService.save(productCustomerDTO);
        assertEquals( productCustomer.getCustomer().getCPF(),productCustomerDTO.getCustomer().getCPF());
    }


    @Test
    void searchProductCustomer() throws Exception{
        List<ProductCustomer> productCustomer =productCustomerService.search("12312312");
        assertEquals (productCustomer.get(0).getProduct().getName(),"cartao");
    }
}
