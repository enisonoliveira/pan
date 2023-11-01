package com.br.pan.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
    
    protected  ResponseEntity<String>  getAddressCEP(String CEP) throws  InterruptedException, URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://viacep.com.br/ws/"+CEP+"/json";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

    protected  ResponseEntity<String>  getAddressCity(String id) throws  InterruptedException, URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+id+"/municipios";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

    protected  ResponseEntity<String>  getAddresState() throws  InterruptedException, URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

   
}
