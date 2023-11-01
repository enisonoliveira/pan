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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StateServiceImpl extends ExternalService implements StateService {

    Logger logger = LoggerFactory.getLogger( StateServiceImpl.class);

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State save(State stateDTO) {
        State search= search(stateDTO.getUF());
        if(search!=null){
            return search;
        }
        return stateRepository.save(stateDTO);
    }

    @Override
    public State update(State stateDTO) {
        return stateRepository.save(stateDTO);
    }

    @Override
    public void delete(State stateDTO) {
         stateRepository.delete(stateDTO);
    }

    @Override
    public State search(String UF) {
        return  stateRepository.search(UF);
    }


    @Override
    public  State searchExternal(String UF)  {
        ResponseEntity<String> states=null;
        try {
            states = super.searchUF(UF);
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String convert = states.getBody();
        State state=null;
        EstadosRequestResponse stateResponse = null;
        try {
            stateResponse = objectMapper.readValue(convert, EstadosRequestResponse.class);
            logger.info(stateResponse.getNome());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        state = new State(Long.parseLong(stateResponse.getId()),stateResponse.getNome(), stateResponse.getSigla());
        return  state;
    }
    
}
