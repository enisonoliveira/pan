package com.br.pan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String CPF;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Product> productCol;

    public Customer(String name, String cPF, Address address, List<Product> productCol) {
        this.name = name;
        CPF = cPF;
        this.address = address;
        this.productCol = productCol;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductCol() {
        return productCol;
    }

    public void setProductCol(List<Product> productCol) {
        this.productCol = productCol;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        this.CPF = cPF;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
