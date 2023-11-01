package com.br.pan.service;

import java.net.URISyntaxException;

import com.br.pan.model.Address;
import com.br.pan.vo.EstadosRequestResponse;

import org.springframework.http.ResponseEntity;

public interface AddressService {
    
    public Address save(Address addressDTO );

    public Address update(Address addressDTO );

    public  Address  search(String CEP ) throws URISyntaxException, InterruptedException;

    public   EstadosRequestResponse[] searchAllState() throws InterruptedException, URISyntaxException ;

    public void delete(Address addressDTO );

    public  ResponseEntity<String>  searchCity(String id) throws URISyntaxException, InterruptedException ;
}
