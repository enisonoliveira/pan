package com.br.pan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.br.pan.model.ProductCustomer;

@Repository
public interface ProductCustomerRepository extends JpaRepository<ProductCustomer,Long>{

    @Query("SELECT A FROM ProductCustomer A INNER JOIN A.customer C WHERE C.CPF=?1")
    List<ProductCustomer> search(String cPFCustomer);
}
