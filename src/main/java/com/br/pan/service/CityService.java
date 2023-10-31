package com.br.pan.service;

import com.br.pan.model.City;

public interface CityService {
    
    public City save(City  cityDTO);

    public City update(City  cityDTO);

    public void delete(City  cityDTO);

    public City search(String CEP);
}
