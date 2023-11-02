package com.br.pan.service;

import com.br.pan.model.Location;

public interface LocationService {

    public Location save(Location cityDTO) throws Exception;

    public Location update(Location cityDTO) throws Exception;

    public void delete(Location cityDTO) throws Exception;

    public Location search(Long id) throws Exception;

    public Location searchExternal(String id) throws Exception;

}
