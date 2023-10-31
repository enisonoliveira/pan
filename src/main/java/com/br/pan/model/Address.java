package com.br.pan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    private State  state;

    public Address(State state) {
        this.state = state;
    }
   
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
