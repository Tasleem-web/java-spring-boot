package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
