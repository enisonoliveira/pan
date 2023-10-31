package com.br.pan.service.impl;

import com.br.pan.model.State;
import com.br.pan.repository.StateRepository;
import com.br.pan.service.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State save(State stateDTO) {
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
    
}
