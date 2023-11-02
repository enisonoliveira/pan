package com.br.pan.service.impl;

import java.net.URISyntaxException;

import com.br.pan.model.State;
import com.br.pan.repository.StateRepository;
import com.br.pan.service.StateService;
import com.br.pan.vo.EstadosRequestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StateServiceImpl extends ExternalService implements StateService {

    Logger logger = LoggerFactory.getLogger( StateServiceImpl.class);

    @Autowired
    private StateRepository stateRepository;

     /*
    *@see public State save(State stateDTO) 
    */
    @Override
    public State save(State stateDTO) {
        State search= search(stateDTO.getUF());
        if(search!=null){
            logger.warn("===estado já exite na base de dados====");
            return search;
        }
        logger.info("====salvando estado====");
        return stateRepository.save(stateDTO);
    }

    /*
    *@see  public void delete(State stateDTO)
    */
    @Override
    public State update(State stateDTO) {
        logger.info("====alterando estado====");
        return stateRepository.save(stateDTO);
    }
    /*
    *@see  public void delete(State stateDTO)
    */
    @Override
    public void delete(State stateDTO) {
        logger.info("====deletando estado====");
         stateRepository.delete(stateDTO);
    }

    /*
    *@see public State search(String UF)
    */
    @Override
    public State search(String UF) {
        logger.info("====buscando todos os estado exitente na base====");
        return  stateRepository.search(UF);
    }

    /*
    *@see   public  State searchExternal(String UF)
    */
    @Override
    @Cacheable(value = "_methods")
    public  State searchExternal(String UF)  {
        ResponseEntity<String> states=null;
        try {
            states = super.searchUF(UF);
        } catch (URISyntaxException e1) {
            logger.error(e1.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String convert = states.getBody();
        State state=null;
        EstadosRequestResponse stateResponse = null;
        try {
            stateResponse = objectMapper.readValue(convert, EstadosRequestResponse.class);
            logger.info(stateResponse.getNome());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        state = new State(Long.parseLong(stateResponse.getId()),stateResponse.getNome(), stateResponse.getSigla());
        return  state;
    }
    
}
