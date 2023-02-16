package com.springbootbackendapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.Student;
import com.springbootbackendapp.repository.StudentRepository;
import com.springbootbackendapp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student checkExistsOrNot = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));

		checkExistsOrNot.setEmail(student.getEmail());
		checkExistsOrNot.setFirstName(student.getFirstName());
		checkExistsOrNot.setLastName(student.getLastName());

		studentRepository.save(checkExistsOrNot);
		return checkExistsOrNot;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
		studentRepository.deleteById(id);
	}
}
