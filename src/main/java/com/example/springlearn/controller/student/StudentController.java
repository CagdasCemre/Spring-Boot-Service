package com.example.springlearn.controller.student;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.model.student.Student;
import com.example.springlearn.service.student.StudentService;

@RestController
@RequestMapping("api/student/{id}")
public class StudentController {

private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping
	public Student getStudent(@PathVariable("id") String id) {
		return studentService.getStudent(id);
	}
	
	@PatchMapping
	public Student updateStudent(@PathVariable("id") String id,
			@RequestParam(value = "name") Optional<String> name,
			@RequestParam(value = "email") Optional<String> email,
			@RequestParam(value = "dob") Optional<String> dob,
			@RequestParam(value = "age") Optional<String> age) {
		return studentService.updateStudent(id, name, email, dob, age);
	}
	
	@DeleteMapping
	public Student deleteStudent(@PathVariable("id") String id) {
		return studentService.deleteStudent(id);
	}
	
}
