package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
