package com.klef.sdp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Student;
import com.klef.sdp.springboot.model.Faculty;
import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.repository.AdminRepository;
import com.klef.sdp.springboot.repository.StudentRepository;
import com.klef.sdp.springboot.repository.FacultyRepository;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Admin checkadminlogin(String username, String password) 
    {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String addtutor(Faculty faculty) 
    {
        facultyRepository.save(faculty);
        return "Tutor Added Successfully";
    }

    @Override
    public List<Faculty> viewalltutors() 
    {
        return facultyRepository.findAll();
    }

    @Override
    public List<Student> viewallstudents() 
    {
        return studentRepository.findAll();
    }

    @Override
    public String deletetutor(int tid) 
    {
        Optional<Faculty> faculty = facultyRepository.findById(tid);

        if (faculty.isPresent()) 
        {
            facultyRepository.deleteById(tid);
            return "Tutor Deleted Successfully";
        } 
        else 
        {
            return "Tutor ID Not Found";
        }
    }
}
