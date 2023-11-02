package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.pan.model.Location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityServiceImplTest {
    
    @Autowired
    private LocationService cityService;

    @Test
    @BeforeEach
    void saveAddressTest() throws Exception{
        Location cityDTO = new Location();
        cityDTO.setName("Fazendinha");
        cityDTO.setNumero("160030312");
        cityDTO.setId(1L);
        Location city = cityService.save(cityDTO);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }

    @Test
    void updateAddressTest() throws Exception{
        Location cityDTO = new Location();
        cityDTO.setName("Fazendinha");
        cityDTO.setNumero("160030312");
        cityDTO.setId(1L);
        Location city = cityService.update(cityDTO);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }

    @Test
    void saveCitySearchTest() throws Exception{
        Location cityDTO = new Location();
        cityDTO.setName("Fazendinha");
        cityDTO.setNumero("160030312");
        cityDTO.setId(1L);
        cityService.save(cityDTO);
        Location city = cityService.search(1L);
        assertEquals(city.getName(),cityDTO.getName());
        assertEquals(city.getNumero(),cityDTO.getNumero());
    }


}
