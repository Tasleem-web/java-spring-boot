package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee, Long id);

	void deleteEmployee(long id);

}
