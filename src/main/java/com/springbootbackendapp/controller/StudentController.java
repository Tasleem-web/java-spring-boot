package com.springbootbackendapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendapp.model.Student;
import com.springbootbackendapp.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable("id") long id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Student is deleted!.");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}
