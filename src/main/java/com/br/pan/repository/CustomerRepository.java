package com.br.pan.repository;

import com.br.pan.model.Address;
import com.br.pan.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{


    @Query("DELETE FROM Customer  A  WHERE A.CPF=?1")
    void delete(String cPF);

    @Query("SELECT A FROM Customer  A  WHERE A.CPF=?1")
    Customer search(String cPF);

    @Query("SELECT ad FROM Customer A INNER JOIN A.address  ad  WHERE A.CPF=?1")
    Address getAddressCPF(String cpf);
    
}
