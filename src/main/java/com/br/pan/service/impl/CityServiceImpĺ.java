package com.br.pan.service.impl;

import com.br.pan.model.City;
import com.br.pan.repository.CityRepository;
import com.br.pan.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpĺ extends ExternalService implements CityService {

    Logger logger = LoggerFactory.getLogger(CityServiceImpĺ.class);

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City cityDTO) throws Exception {
        City city = search(cityDTO.getId());
        if (city != null) {
            return city;
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public City update(City cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            throw new Exception("Id de Municipio não informado");
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public void delete(City cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            throw new Exception("Id de Municipio não exite");
        }
        cityRepository.delete(cityDTO);
    }

    @Override
    public City search(Long id) throws Exception {
        if (id == null) {
            return null;
        }
        return cityRepository.findById(id).get();
    }

}
