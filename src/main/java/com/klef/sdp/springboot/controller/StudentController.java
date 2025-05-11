package com.klef.sdp.springboot.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.RegisterCourse;
import com.klef.sdp.springboot.model.Student;
import com.klef.sdp.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/registration")
    public ResponseEntity<String> studentregistration(@RequestBody Student s) {
        try {
            String output = studentService.studentregistration(s);
            return ResponseEntity.ok(output); // 200 - success
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Student Registration Failed ...");
        }
    }
    
    @PostMapping("/checkstudentlogin")
    public ResponseEntity<?> checkstudentlogin(@RequestBody Student s) {
        try {
            Student s1 = studentService.checkstudentlogin(s.getEmail(), s.getPassword());

            if (s1 != null) {
                return ResponseEntity.ok(s1); // Login successful
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password"); // Login failed
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }
    
    @PutMapping("/updateprofile")
    public ResponseEntity<String> studentupdateprofile(@RequestBody Student s) {
        try {
            String output = studentService.studentupdateprofile(s);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Update Student ... !!");
        }
    }
    
    @GetMapping("/viewallcourses")
    public ResponseEntity<List<Course>> viewallcourses() {
        List<Course> courses = studentService.viewallcourses();
        return ResponseEntity.ok(courses); // 200 - success
    }

    @PostMapping("/registercourse")
    public ResponseEntity<String> registerCourse(@RequestBody RegisterCourse rc) {
        try {
            int registeringId = new Random().nextInt(900000) + 100000; // Generate a 6-digit ID
            rc.setId(registeringId);

            // Fetch student and course
            Student s = studentService.getStudentById(rc.getStudent().getId());
            Course c = studentService.getCourseById(rc.getCourse().getId()); // Updated to fetch course

            if (s == null || c == null) {
                return ResponseEntity.status(404).body("Student or Course not found");
            }

            rc.setStudent(s);
            rc.setCourse(c);
            rc.setStatus("Registered");

            // Register the course
            String output = studentService.registercourse(rc);

            return ResponseEntity.ok(output); // 200 - success
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Register Course: " + e.getMessage());
        }
    }

    // Get registered courses for a student
    @GetMapping("/registeredcourses/{sid}")
    public ResponseEntity<List<RegisterCourse>> getCourseByStudent(@PathVariable int sid) {
        List<RegisterCourse> bookedCourses = studentService.getregisteredcourseByStudent(sid);
        return ResponseEntity.ok(bookedCourses); // 200 - success
    }
    
    @GetMapping("/getbyemail")
    public ResponseEntity<?> getStudentByEmail(@RequestParam String email) {
        Student s = studentService.getStudentByEmail(email);
        if (s != null) {
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

}
