package com.br.pan.vo;

import java.io.Serializable;

public class CustomerRequest implements Serializable {

    private Long customerId;
    private String name;
    private String cpf;
    private AddressRequest address;
   

    public CustomerRequest(Long customerId, String name, String cpf, AddressRequest address) {
        this.customerId = customerId;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}