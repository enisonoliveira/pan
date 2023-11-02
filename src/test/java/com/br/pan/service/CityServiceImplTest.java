package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.pan.model.City;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityServiceImplTest {
    
    @Autowired
    private CityService cityService;

    @Test
    @BeforeEach
    void saveAddressTest() throws Exception{
        City cityDTO = new City();
        cityDTO.setName("Sorocaba");
        cityDTO.setNumero("22");
        cityDTO.setId(1L);
        City city = cityService.save(cityDTO);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }

    @Test
    void updateAddressTest() throws Exception{
        City cityDTO = new City();
        cityDTO.setName("Sorocaba");
        cityDTO.setNumero("22");
        cityDTO.setId(1L);
        City city = cityService.update(cityDTO);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }

    @Test
    void saveCitySearchTest() throws Exception{
        City cityDTO = new City();
        cityDTO.setName("Fazendinha");
        cityDTO.setNumero("160030312");
        cityDTO.setId(1L);
        cityService.save(cityDTO);
        City city = cityService.search(1L);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }


}
