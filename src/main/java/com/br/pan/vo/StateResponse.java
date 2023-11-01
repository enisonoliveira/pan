package com.br.pan.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("sigla")
    private String sigla;
    @JsonProperty("nome")
    private String nome;
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
    public Regiao getColRegiao() {
        return colRegiao;
    }
    public void setColRegiao(Regiao colRegiao) {
        this.colRegiao = colRegiao;
    }
    @JsonProperty("regiao")
    private Regiao colRegiao;
    
   
}
