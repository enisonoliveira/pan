package com.br.pan.vo;

public class CustomerSaveParams {

    private String name;
    private String CPF;
    private AddressParams address;
    
    public CustomerSaveParams(String name, String CPF, AddressParams address) {
        this.name = name;
        this.CPF = CPF;
        this.address = address;
    }


    public String getName() {
        return name;
    }


    public AddressParams getAddress() {
        return address;
    }
    public void setAddress(AddressParams address) {
        this.address = address;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setName(String name) {
        this.name = name;
    }


}