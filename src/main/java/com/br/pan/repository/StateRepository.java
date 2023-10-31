package com.br.pan.repository;

import com.br.pan.model.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends  JpaRepository<State, Long> {

    @Query("SELECT A FROM State A  WHERE A.UF=?1")
    State search(String uF);
    
}
