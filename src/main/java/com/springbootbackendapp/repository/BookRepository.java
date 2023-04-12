package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
