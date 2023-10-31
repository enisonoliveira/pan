package com.br.pan.enume;

public enum ProductType {

    CARTAO("cartao"), 
    EMPRESTIMO("emprestimo"), 
    CAPITALIZACAO("capitalizacao"), 
    INVESTIMENTO("investimento");

    ProductType(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return type;
    }
}
