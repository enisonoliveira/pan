package com.br.pan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String UF;
    private String name;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<City> collCity;

    public State(Long id, String name, List<City> collCity) {
        this.id = id;
        this.name = name;
        this.collCity = collCity;
    }


    public State() {
    }


    public String getUF() {
        return UF;
    }


    public void setUF(String uF) {
        this.UF = uF;
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
