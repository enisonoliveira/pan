package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @JsonProperty("id")
    private String id;
    @JsonProperty("sigla")
    private String sigla;
    @JsonProperty("nome")
    private String nome;
}
