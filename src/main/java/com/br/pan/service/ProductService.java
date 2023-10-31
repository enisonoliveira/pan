package com.br.pan.service;

import java.util.List;

import com.br.pan.model.Product;

public interface ProductService {
    
    public Product save(Product productDTO);

    public Product update(Product productDTO);

    public void delete(Product productDTO);

    public List<Product> search(String CPF);
}
