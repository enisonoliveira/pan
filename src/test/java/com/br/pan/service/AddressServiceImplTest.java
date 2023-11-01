package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.br.pan.model.Address;
import com.br.pan.model.City;
import com.br.pan.model.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class AddressServiceImplTest {
    
    @Autowired
    private AddressService addressService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;

    @Test
    @BeforeEach
    void saveAddressTest() throws Exception{
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

        Address address=addressService.save(addressDTO);
        assertEquals(address.getNeigborHood(), addressDTO.getNeigborHood());
        assertEquals(address.getNumber(), addressDTO.getNumber());
        assertEquals(address.getZipCode(), addressDTO.getZipCode());
        assertEquals(address.getStreet(), addressDTO.getStreet());
    }

    @Test
    void search() throws Exception{
        Address addressDTO = addressService.search("18070090");

        Address address = new Address();

        address.setNeigborHood("Vila Guilherme");
        address.setStreet("Rua Fernão Dias Falcão");
        address.setNumber(0);
        address.setZipCode(null);

        assertEquals(address.getNeigborHood(), addressDTO.getNeigborHood());
        assertEquals(address.getNumber(), addressDTO.getNumber());
        assertEquals(address.getZipCode(), addressDTO.getZipCode());
        assertEquals(address.getStreet(), addressDTO.getStreet());
    }


    @Test
    void searchCity() throws Exception{
        ResponseEntity<String> resp = addressService.searchCity("33");
        assertNotEquals( null,resp.getBody());

     
    }
}
