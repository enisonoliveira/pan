package com.br.pan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
