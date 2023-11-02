package com.br.pan.service.impl;

import com.br.pan.model.Location;
import com.br.pan.repository.CityRepository;
import com.br.pan.service.LocationService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpĺ extends ExternalService implements LocationService {

    Logger logger = LoggerFactory.getLogger(LocationServiceImpĺ.class);

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Location save(Location cityDTO) throws Exception {

        if (cityRepository.existsById(cityDTO.getId())) {
            logger.warn("===município já exite na base de dados====");
            return cityDTO;
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public Location update(Location cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            logger.error("===Id de Municipio não informado====");
            throw new Exception("Id de Municipio não informado");
        }
        return cityRepository.save(cityDTO);
    }

    @Override
    public void delete(Location cityDTO) throws Exception {
        if (!cityRepository.existsById(cityDTO.getId())) {
            logger.error("===Id de Municipio não exite====");
            throw new Exception("Id de Municipio não exite");
        }
        cityRepository.delete(cityDTO);
    }

    @Override
    public Location search(Long id) throws Exception {
        if (id == null) {
            logger.warn("===Id nulo====");

        }
        logger.info("listando");
        return cityRepository.findById(id).get();
    }

    @Override
    public Location searchExternal(String id) throws Exception {
        if (id == null) {
            logger.warn("===Id nulo====");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ResponseEntity<String> states = super.searchLocation(String.valueOf(id));
        JsonNode nodes = objectMapper.readTree(states.getBody());
        Location city = new Location();
        if(nodes.size()==0){
            logger.error("===Código IBGE inexistente====");
            throw new Exception("código único IBGE do Municipio esta incorreto");
        }
        city.setId(nodes.get(0).get("id").asLong());
        city.setName(nodes.get(0).get("nome").asText());
        city.setNumero(nodes.get(0).get("id").asText());
        return city;
    }

}
