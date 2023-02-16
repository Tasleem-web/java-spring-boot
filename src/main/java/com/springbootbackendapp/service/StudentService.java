package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.Student;

public interface StudentService {

	List<Student> getStudents();

	Student saveStudent(Student student);

	Student getStudentById(long id);

	Student updateStudent(Student student, long id);

	void deleteStudent(long id);
}
