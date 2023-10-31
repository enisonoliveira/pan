package com.br.pan.vo;


public class AddressParams {
    private String street;
    private String neigborHood;
    private String zipCode;
    private String city;
    private int number;
    private String state;
    private String nameCity;
    private String UF;

    public AddressParams(String street, String neigborHood, String zipCode, String city, int number, String state) {
        this.street = street;
        this.neigborHood = neigborHood;
        this.zipCode = zipCode;
        this.city = city;
        this.number = number;
        this.state = state;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public String getUF() {
        return UF;
    }


    public void setUF(String uF) {
        this.UF = uF;
    }

   
   
    
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
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
    

    public String getNameCity() {
        return nameCity;
    }
}
