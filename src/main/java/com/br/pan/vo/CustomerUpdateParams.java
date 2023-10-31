package com.br.pan.vo;


public class CustomerUpdateParams {

    private String CPF;
    private AddressParams address;
    
    public CustomerUpdateParams( String CPF, AddressParams address) {
        this.CPF = CPF;
        this.address = address;
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

}