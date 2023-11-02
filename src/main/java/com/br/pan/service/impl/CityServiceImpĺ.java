package com.br.pan.service.impl;

import com.br.pan.model.City;
import com.br.pan.repository.CityRepository;
import com.br.pan.service.CityService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpĺ extends ExternalService implements CityService {

    Logger logger = LoggerFactory.getLogger(CityServiceImpĺ.class);

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City cityDTO) throws Exception {

        if (cityRepository.existsById(cityDTO.getId())) {
            logger.warn("===município já exite na base de dados====");
            return cityDTO;
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public City update(City cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            logger.error("===Id de Municipio não informado====");
            throw new Exception("Id de Municipio não informado");
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public void delete(City cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            logger.error("===Id de Municipio não exite====");
            throw new Exception("Id de Municipio não exite");
        }
        cityRepository.delete(cityDTO);
    }

    @Override
    public City search(Long id) throws Exception {
        if (id == null) {
            logger.warn("===Id nulo====");

        }
        logger.info("listando");
        return cityRepository.findById(id).get();
    }

    @Override
    public City searchExternal(String id) throws Exception {
        if (id == null) {
            logger.warn("===Id nulo====");

        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ResponseEntity<String> states = super.searchLocation(String.valueOf(id));
        JsonNode nodes = objectMapper.readTree(states.getBody());
        City city = new City();
        city.setId(nodes.get(0).get("id").asLong());
        city.setName(nodes.get(0).get("nome").asText());
        city.setNumero(nodes.get(0).get("id").asText());
        return city;
    }

}
