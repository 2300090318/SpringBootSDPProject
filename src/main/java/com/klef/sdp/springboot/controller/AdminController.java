
package com.klef.sdp.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.model.Student;
import com.klef.sdp.springboot.model.Faculty;
import com.klef.sdp.springboot.service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController 
{
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/checkadminlogin")
    public ResponseEntity<?> checkadminlogin(@RequestBody Admin admin)
    {
        try 
        {
            Admin a = adminService.checkadminlogin(admin.getUsername(), admin.getPassword());
            if (a != null) 
            {
                return ResponseEntity.ok(a);
            } 
            else 
            {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }
    
    @GetMapping("/viewallfaculties")
    public ResponseEntity<List<Faculty>> viewalltutors()
    {
        List<Faculty> faculties = adminService.viewalltutors();
        return ResponseEntity.ok(faculties);
    }
    
    @PostMapping("/addfaculty")
    public ResponseEntity<String> addtutor(@RequestBody Faculty faculty)
    {
        try
        {
            String output = adminService.addtutor(faculty);
            return ResponseEntity.ok(output);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Failed to Add Tutor");
        }
    }
    
    @GetMapping("/viewallstudents")
    public ResponseEntity<List<Student>> viewallstudents()
    {
        List<Student> students = adminService.viewallstudents();
        return ResponseEntity.ok(students);
    }
    
    @DeleteMapping("/deletetutor")
    public ResponseEntity<String> deletetutor(@RequestParam int tid)
    {
  	  try
  	   {
  		  String output = adminService.deletetutor(tid);
  		  return ResponseEntity.ok(output);
  	   }
  	   catch(Exception e)
  	   {
  		    return ResponseEntity.status(500).body("Failed to Delete Tutor ... !!"); 
  	   }
    }
    

}