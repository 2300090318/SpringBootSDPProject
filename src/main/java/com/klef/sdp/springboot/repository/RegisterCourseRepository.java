package com.klef.sdp.springboot.repository;

import com.klef.sdp.springboot.model.RegisterCourse;
import com.klef.sdp.springboot.model.Student;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterCourseRepository extends JpaRepository<RegisterCourse, Integer> {
    
    @Modifying
    @Transactional
    @Query("UPDATE RegisterCourse r SET r.status = :status WHERE r.id = :id")
    void updateStatusById(@Param("id") String id, @Param("status") int status);

	List<RegisterCourse> findByStudent(Student s);
}

  

