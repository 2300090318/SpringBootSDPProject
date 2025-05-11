package com.klef.sdp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Course;
import com.klef.sdp.springboot.model.RegisterCourse;
import com.klef.sdp.springboot.model.Student;
import com.klef.sdp.springboot.repository.CourseRepository;
import com.klef.sdp.springboot.repository.RegisterCourseRepository;
import com.klef.sdp.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService 
{
    @Autowired
    private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RegisterCourseRepository registerCourseRepository;


	@Override
	public String studentregistration(Student s) {
		studentRepository.save(s);
		return "Student Registered Successfully";

	}

	@Override
	public Student checkstudentlogin(String email, String password) {
		return studentRepository.findByEmailAndPassword(email, password);

	}

	@Override
	public String studentupdateprofile(Student s) {
     Optional<Student> object	= studentRepository.findById(s.getId());
		
		String msg = null;
			  
			  if(object.isPresent())
			  {
				  Student s1 = object.get();
				  
				  s1.setName(s.getName());
				  s1.setEmail(s.getEmail());
				  s1.setPassword(s.getPassword());
				  s1.setLocation(s.getLocation());
				  s1.setPhone(s.getPhone());
				  s1.setGrade(s.getGrade());

				  
				  studentRepository.save(s1);
				  
				  msg = "Student  Profile Updated Successfully";
			  }
			  else
			  {
				  msg = "Student ID Not Found to Update";
			  }
			  return msg;
	}

	@Override
	public List<Course> viewallcourses() {
		   return courseRepository.findAll();

	}

	@Override
	public Student getStudentById(int sid) {
		return studentRepository.findById(sid).orElse(null);

	}

	@Override
	public Course getCourseById(int cid) {
		return courseRepository.findById(cid).orElse(null);

	}

	@Override
	public String registercourse(RegisterCourse rc) {
		registerCourseRepository.save(rc);
		return "Course Registered Successfully";
	}

	@Override
	public List<RegisterCourse> getregisteredcourseByStudent(int sid) {
		Student s = studentRepository.findById(sid).orElse(null);
		return registerCourseRepository.findByStudent(s);

	}

	@Override
	public List<RegisterCourse> getbregisteredCoursesByStudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}
	public Student getStudentByEmail(String email) {
	    return studentRepository.findByEmail(email);
	}


   
}