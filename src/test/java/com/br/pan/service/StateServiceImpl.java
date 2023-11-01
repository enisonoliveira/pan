package com.br.pan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.pan.model.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StateServiceImpl {

    @Autowired
    private StateService stateService;


    @Test
    @BeforeEach
    void setUp(){
        State stateDTO = new State();
        stateDTO.setName("São Paulo");
        stateDTO.setUF("SP");
        State state=stateService.save(stateDTO);
        assertEquals(state.getName(), stateDTO.getName());
        assertEquals(state.getUF(), stateDTO.getUF());

    }

    @Test
    void updateTest(){
        State stateDTO = new State();
        stateDTO.setName("São Paulo");
        stateDTO.setUF("SP");
        stateDTO.setId(1L);
        State state=stateService.update(stateDTO);
        assertEquals(state.getName(), stateDTO.getName());
        assertEquals(state.getUF(), stateDTO.getUF());

    }

    @Test
    void searchExternalUF(){
        State stateDTO = new State();
        stateDTO.setName("São Paulo");
        stateDTO.setUF("SP");
        State state=stateService.searchExternal("SP");
        assertEquals(state.getName(), stateDTO.getName());
        assertEquals(state.getUF(), stateDTO.getUF());

    }
}
