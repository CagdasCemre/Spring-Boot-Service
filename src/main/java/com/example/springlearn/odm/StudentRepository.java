package com.example.springlearn.odm;

import java.util.List;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.example.springlearn.model.student.Student;

@Repository
public interface StudentRepository extends CouchbaseRepository<Student, String> {
	List<Student> findByEmailLike(String name);
}
