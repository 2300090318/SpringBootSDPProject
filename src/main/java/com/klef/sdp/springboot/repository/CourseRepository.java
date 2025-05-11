package com.klef.sdp.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.Faculty;



@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findByFaculty(Faculty faculty);
	
	 @Query("select count(c) from Course c")
	 public long coursecount();

	public List<Course> findByFacultyId(int fid);


}
