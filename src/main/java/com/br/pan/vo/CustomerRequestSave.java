package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CustomerRequestSave {

    private String nome;
    private String CPF;
    private EnderecoRequestResponse address;
    
    public CustomerRequestSave(String nome, String CPF, EnderecoRequestResponse address) {
        this.setNome(nome);
        this.CPF = CPF;
        this.address = address;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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