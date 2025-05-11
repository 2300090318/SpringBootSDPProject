package com.klef.sdp.springboot.service;


import java.util.List;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.RegisterCourse;
import com.klef.sdp.springboot.model.Student;

public interface StudentService 
{
	public String studentregistration(Student s);
	  public Student checkstudentlogin(String username,String password);
	  
	  public String studentupdateprofile(Student s);
	  public List<Course> viewallcourses();
	  
	  public Student getStudentById(int sid);
	  public Course getCourseById(int cid);
	  
	  public String registercourse(RegisterCourse rc);
	  public List<RegisterCourse> getregisteredcourseByStudent(int sid);
	public List<RegisterCourse> getbregisteredCoursesByStudent(int sid);
	public Student getStudentByEmail(String email);

}