package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
