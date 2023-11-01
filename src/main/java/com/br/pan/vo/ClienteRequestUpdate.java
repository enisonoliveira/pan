package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ClienteRequestUpdate {

    private String CPF;
    private EnderecoRequestResponse address;
    
    public ClienteRequestUpdate( String CPF, EnderecoRequestResponse address) {
        this.CPF = CPF;
        this.address = address;
    }


    public EnderecoRequestResponse getAddress() {
        return address;
    }
    public void setAddress(EnderecoRequestResponse address) {
        this.address = address;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}