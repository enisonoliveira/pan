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
    private MunicipioRequest colRegiao;
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
    public MunicipioRequest getColRegiao() {
        return colRegiao;
    }
    public void setColRegiao(MunicipioRequest colRegiao) {
        this.colRegiao = colRegiao;
    }
   
    
   
}
