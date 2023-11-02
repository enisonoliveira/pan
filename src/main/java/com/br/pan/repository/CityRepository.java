package com.br.pan.repository;

import com.br.pan.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository  extends JpaRepository<Location, Long>{

    
}
