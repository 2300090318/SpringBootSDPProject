package com.klef.sdp.springboot.service;

import java.util.List;
import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.model.Student;
import com.klef.sdp.springboot.model.Faculty;

public interface AdminService 
{
    Admin checkadminlogin(String username, String password);
    String addtutor(Faculty faculty);
    List<Faculty> viewalltutors();
    List<Student> viewallstudents();
    public String deletetutor(int tid);
    

}