package com.klef.sdp.springboot.service;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.Faculty;
import com.klef.sdp.springboot.model.RegisterCourse;
import java.util.List;

public interface FacultyService {
    Faculty checkFacultyLogin(String username, String password);
    String addCourse(Course course);
    Faculty getFacultyById(int fid);
    List<Course> viewCoursesByFaculty(int fid);
    //List<RegisterCourse> getRegistrationsByFaculty(int fid);
    String updateRegistrationStatus(int id, String status);
	List<Faculty> viewAllFaculty();
}