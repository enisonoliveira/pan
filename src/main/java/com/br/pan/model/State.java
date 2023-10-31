package com.br.pan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class State {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<City> collCity;

    public State(Long id, String name, List<City> collCity) {
        this.id = id;
        this.name = name;
        this.collCity = collCity;
    }


    public List<City> getCollCity() {
        return collCity;
    }

    public void setCollCity(List<City> collCity) {
        this.collCity = collCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
