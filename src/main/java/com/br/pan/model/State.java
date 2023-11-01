package com.br.pan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class State {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String UF;
    private String name;
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public State(Long id, String name, String UF) {
        this.id = id;
        this.name = name;
        this.UF=UF;
    }


    public State() {
    }


    public String getUF() {
        return UF;
    }


    public void setUF(String uF) {
        this.UF = uF;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
