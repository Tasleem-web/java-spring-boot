package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
