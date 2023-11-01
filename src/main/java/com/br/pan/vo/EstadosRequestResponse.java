package com.br.pan.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class EstadosRequestResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("sigla")
    private String sigla;
    @JsonProperty("regiao")
    private Location colRegiao;
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
    public Location getColRegiao() {
        return colRegiao;
    }
    public void setColRegiao(Location colRegiao) {
        this.colRegiao = colRegiao;
    }
   
    
   
}
