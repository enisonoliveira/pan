package com.br.pan.service.impl;

import com.br.pan.model.City;
import com.br.pan.repository.CityRepository;
import com.br.pan.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpĺ  implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City cityDTO) {
        return cityRepository.save(cityDTO);
    }

    @Override
    public City update(City cityDTO) {
        return cityRepository.save(cityDTO);
    }

    @Override
    public void delete(City cityDTO) {
         cityRepository.delete(cityDTO);
    }

    @Override
    public City search(String CEP) {
        return null;
    }
    
}
