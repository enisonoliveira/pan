package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ProdutoRequestResponse {
    
    private String producName;

    private Long id;
   

    public String getProducName() {
        return producName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }
    
}
