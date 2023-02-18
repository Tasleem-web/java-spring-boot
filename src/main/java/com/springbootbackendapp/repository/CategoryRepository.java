package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
