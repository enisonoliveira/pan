package com.br.pan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private State state;
    @ManyToOne
    private Location city;
    private String street;
    private String neigborHood;
    private String zipCode;
    private int number;

    public Address(Long id, State state,
            Location city, String street, String neigborHood,
            String zipCode, int number) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.neigborHood = neigborHood;
        this.zipCode = zipCode;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address(State state) {
        this.state = state;
    }

    public Location getCity() {
        return city;
    }

    public void setCity(Location city) {
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
