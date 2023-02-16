package com.springbootbackendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
