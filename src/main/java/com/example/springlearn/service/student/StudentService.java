package com.example.springlearn.service.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springlearn.model.student.Student;
import com.example.springlearn.odm.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudent(String id) {
		Optional<Student> foundStudent = studentRepository.findById(id);
		if(foundStudent.isPresent()) {
			return foundStudent.get();
		}
			return null;
	}
	
	public Student updateStudent(String id ,Optional<String> name,
			Optional<String> email,
			Optional<String> dob,
			Optional<String> age) {
		Optional<Student> foundStudent = studentRepository.findById(id);
		if(foundStudent.isPresent()) {
			Student student = foundStudent.get();
			if(name.isPresent() && !name.get().equals("")) student.setName(name.get());
			if(email.isPresent() && !email.get().equals("")) student.setEmail(email.get());
			if(dob.isPresent() && !dob.get().equals("")) student.setDob(LocalDate.parse(dob.get()));
			if(age.isPresent() && !age.get().equals("")) student.setAge(Integer.parseInt(age.get()));
			studentRepository.save(student);
			return student;
		}
		return null;
	}
	
	public Student deleteStudent(String id) {
		Optional<Student> foundStudent = studentRepository.findById(id);
		if(foundStudent.isPresent()) {			
			studentRepository.deleteById(id);
			return foundStudent.get();
		}
		return null;
	}	
	
	public int addStudent(Student newStudent) {
		studentRepository.save(newStudent);
		return 1;
	}
	
}
