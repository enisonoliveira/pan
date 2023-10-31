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

    private String CEP;
    private String name;

    public City(String cEP, String name) {
        CEP = cEP;
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        this.CEP = cEP;
    }

}
