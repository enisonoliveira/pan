package com.br.pan.service.impl;

import java.net.URI;
import java.net.URISyntaxException;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ExternalService {
    
    Logger logger = LoggerFactory.getLogger( ExternalService.class);

    protected  ResponseEntity<String>  getAddressCEP(String CEP) throws  InterruptedException, URISyntaxException {
        logger.info("====ExternalService  buscando o endereço pelo CEP====");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://viacep.com.br/ws/"+CEP+"/json";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

    protected  ResponseEntity<String>  getAddressCity(String id) throws  InterruptedException, URISyntaxException {
        logger.info("====ExternalService  buscando o municipio====");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+id+"/municipios";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

    protected  ResponseEntity<String>  getAddresState() throws  InterruptedException, URISyntaxException {
        logger.info("====ExternalService  listando os estados====");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }
 //https://servicodados.ibge.gov.br/api/v1/localidades/distritos/
    public  ResponseEntity<String>   searchUF(String uF) throws URISyntaxException {
        logger.info("====ExternalService buscando o estado pelo UF====");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+uF;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }

    public  ResponseEntity<String>   searchLocation(String ibge) throws URISyntaxException {
        logger.info("====ExternalService buscando o estado pelo UF====");
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl ="https://servicodados.ibge.gov.br/api/v1/localidades/distritos/"+ibge;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result=restTemplate.getForEntity(uri, String.class);
        return result;
    }


   
}
