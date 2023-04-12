package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Zipcode;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {

}
