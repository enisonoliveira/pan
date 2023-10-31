package com.br.pan.service;

import com.br.pan.model.Address;

public interface AddressService {
    
    public Address save(Address addressDTO );

    public Address update(Address addressDTO );

    public Address search(String CEP );

    public void delete(Address addressDTO );
}
