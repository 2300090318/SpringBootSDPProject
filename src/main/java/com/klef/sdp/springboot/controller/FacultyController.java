package com.klef.sdp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.sdp.springboot.model.Faculty;
import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@CrossOrigin("*")
public class FacultyController 
{
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/login")
    public ResponseEntity<?> checkFacultyLogin(@RequestBody Faculty faculty) 
    {
        Faculty loggedFaculty = facultyService.checkFacultyLogin(faculty.getUsername(), faculty.getPassword());
        
        if (loggedFaculty != null) 
        {
            return ResponseEntity.ok(loggedFaculty); 
        } 
        else 
        {
            return ResponseEntity.status(401).body("Invalid Username or Password"); 
        }
    }

    @PostMapping("/addcourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) 
    {
        String response = facultyService.addCourse(course);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/viewcourses/{fid}")
    public ResponseEntity<List<Course>> viewCoursesByFaculty(@PathVariable int fid) 
    {
        List<Course> courses = facultyService.viewCoursesByFaculty(fid);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/update-registration-status/{id}/{status}")
    public ResponseEntity<String> updateRegistrationStatus(@PathVariable int id, @PathVariable String status) 
    {
        String response = facultyService.updateRegistrationStatus(id, status);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/viewallfaculty")
    public ResponseEntity<List<Faculty>> viewAllFaculty() {
        List<Faculty> facultyList = facultyService.viewAllFaculty();  // Make sure you have a service method for this
        return ResponseEntity.ok(facultyList);
    }

}