package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class EnderecoRequestResponse {
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("nomeMunicipio")
    private String nomeMunicipio;
    @JsonProperty("numero")
    private int numero;
    @JsonProperty("numeroIBGEMunicipio")
    private String numeroIBGEMunicipio;
    @JsonProperty("localidade")
    private String localidade;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("uf")
    private String uf;

    public String getNumeroIBGEMunicipio() {
        return numeroIBGEMunicipio;
    }
    public void setNumeroIBGEMunicipio(String numeroIBGEMunicipio) {
        this.numeroIBGEMunicipio = numeroIBGEMunicipio;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getNomeMunicipio() {
        return nomeMunicipio;
    }
    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
   
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
}
