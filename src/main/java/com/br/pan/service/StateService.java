package com.br.pan.service;

import com.br.pan.model.State;

public interface StateService {
    
    public State save( State stateDTO);

    public State update( State stateDTO);

    public void delete( State stateDTO);

    public State search( String UF);
}
