package com.br.pan.service;

import com.br.pan.model.City;

public interface CityService {

    public City save(City cityDTO) throws Exception;

    public City update(City cityDTO) throws Exception;

    public void delete(City cityDTO) throws Exception;

    public City search(Long id) throws Exception;

    public City searchExternal(String id) throws Exception;

}
