package com.br.pan.controller;


import com.br.pan.service.AddressService;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AddressController {
    

    Logger logger = LoggerFactory.getLogger( AddressController.class);

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/address/search", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> searchCity(@RequestParam String CEP) throws Exception {
        
        Gson gson = new Gson ( );
        return ResponseEntity
        .status( HttpStatus.OK)
        .header("X-Reason", "ok")
        .body(gson.toJson(addressService.search(CEP)));
    }

    @GetMapping(value = "/address/search/state", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> searchUF(@RequestParam String UF) throws Exception {
        
        Gson gson = new Gson ( );
        return ResponseEntity
        .status( HttpStatus.OK)
        .header("X-Reason", "ok")
        .body(gson.toJson(addressService.searchState(UF)));
    }
}
