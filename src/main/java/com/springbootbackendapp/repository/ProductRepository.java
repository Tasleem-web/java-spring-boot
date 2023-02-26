package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
