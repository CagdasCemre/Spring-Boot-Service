package com.example.springlearn.controller.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.model.student.Student;
import com.example.springlearn.service.student.StudentService;

@RestController
@RequestMapping("/api/student")
public class RepoController {
	
	private final StudentService studentService;
	
	@Autowired
	public RepoController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents(); 
	}
	
	@PostMapping
	public int addStudent(@RequestParam(value = "name", defaultValue = "Dummy") String name,
						@RequestParam(value = "email", defaultValue = "dummy@example.com") String email,
						@RequestParam(value = "dob", defaultValue = "2003-01-01") String dob,
						@RequestParam(value = "age", defaultValue = "18") String age) {
		
		Student newStudent = new Student(name, email, LocalDate.parse(dob), Integer.parseInt(age));
		studentService.addStudent(newStudent);
		return 1;
	}

}
