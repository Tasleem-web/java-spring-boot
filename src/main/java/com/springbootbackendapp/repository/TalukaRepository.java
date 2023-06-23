package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbackendapp.model.Talukas;

@Repository
public interface TalukaRepository extends JpaRepository<Talukas, Long> {

}
