package com.klef.sdp.springboot.service;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.Faculty;
import com.klef.sdp.springboot.model.RegisterCourse;
import com.klef.sdp.springboot.repository.FacultyRepository;
import com.klef.sdp.springboot.repository.CourseRepository;
import com.klef.sdp.springboot.repository.RegisterCourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegisterCourseRepository registerCourseRepository;

    @Override
    public Faculty checkFacultyLogin(String username, String password) {
        // Validate username and password, return the faculty object if valid
        Faculty faculty = facultyRepository.findByUsernameAndPassword(username, password);
        return faculty;
    }

    @Override
    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Course added successfully!";
    }

    @Override
    public Faculty getFacultyById(int fid) {
        return facultyRepository.findById(fid).orElse(null);
    }

    @Override
    public List<Course> viewCoursesByFaculty(int fid) {
        return courseRepository.findByFacultyId(fid);
    }

    //@Override
//    public List<RegisterCourse> getRegistrationsByFaculty(int fid) {
//        return registerCourseRepository.findByCourse_FacultyId(fid);
//    }

    @Override
    public String updateRegistrationStatus(int id, String status) {
        Optional<RegisterCourse> regCourseOpt = registerCourseRepository.findById(id);
        if (regCourseOpt.isPresent()) {
            RegisterCourse regCourse = regCourseOpt.get();
            regCourse.setStatus(status);
            registerCourseRepository.save(regCourse);
            return "Registration status updated successfully!";
        }
        return "Registration not found!";
    }

    @Override
    public List<Faculty> viewAllFaculty() {
        // Fetch all faculty members from the database
        return facultyRepository.findAll();
    }
}