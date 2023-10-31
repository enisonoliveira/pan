package com.br.pan.service.impl;

import com.br.pan.model.Address;
import com.br.pan.repository.AddressRepository;
import com.br.pan.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
 
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    @Override
    public Address save(Address addressDTO) {
        return addressRepository.save(addressDTO);
    }

    @Override
    public Address update(Address addressDTO) {
        return  addressRepository.save(addressDTO);
    }

    @Override
    public Address search(String CEP) {
        return null;
    }

    @Override
    public void delete(Address addressDTO) {
         addressRepository.delete(addressDTO);
    }

    @Override
    public Address searchState(String state) {
        return null;

    }
    
}
