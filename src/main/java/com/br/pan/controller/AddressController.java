package com.br.pan.controller;

import java.net.URISyntaxException;

import com.br.pan.service.AddressService;
import com.br.pan.service.LocationService;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.pan.model.Location;

@Controller
public class AddressController {

    Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;
    @Autowired
    private LocationService cityService;

    @GetMapping(value = "/address/search")
    public ResponseEntity<String> searchCEP(@RequestParam String CEP) throws Exception {

        Gson gson = new Gson();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Reason", "ok")
                .body(gson.toJson(addressService.search(CEP)));
    }

    @GetMapping(value = "/address/search/location")
    public  @ResponseBody Location searchCityId(@RequestParam String codigo) throws Exception {

        return cityService.searchExternal(codigo);
    }

    @GetMapping(value = "/address/search/state")
    public ResponseEntity<String> searchUF() throws InterruptedException, URISyntaxException {
        Gson gson = new Gson();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Reason", "ok")
                .body(gson.toJson(addressService.searchAllState()));
    }
}
