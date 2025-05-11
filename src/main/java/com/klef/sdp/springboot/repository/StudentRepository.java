package com.klef.sdp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sdp.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> 
{
    Student findByEmailAndPassword(String email, String password);

	Student findByEmail(String email);
}