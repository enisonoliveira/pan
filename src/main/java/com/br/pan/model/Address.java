package com.br.pan.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private State  state;
    @ManyToOne
    private City  city;
    private String street;
    private String neigborHood;
    private String zipCode;
    private int number;

    public Address(State state) {
        this.state = state;
    }
   
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeigborHood() {
        return neigborHood;
    }

    public void setNeigborHood(String neigborHood) {
        this.neigborHood = neigborHood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
