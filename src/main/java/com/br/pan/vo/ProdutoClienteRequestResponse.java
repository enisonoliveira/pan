package com.br.pan.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ProdutoClienteRequestResponse {
    private Long customerId;
    private Long producId;
  
    public Long getProducId() {
        return producId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProducId(Long producId) {
        this.producId = producId;
    }

}
