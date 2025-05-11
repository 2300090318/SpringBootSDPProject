package com.klef.sdp.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "register_course")
public class RegisterCourse 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Faculty course;
    
    @Column(nullable = false)
    private LocalDate registrationDate;
    
    @Column(length = 50, nullable = false)
    private String status;
    
    @Column(length = 50, nullable = false)
    private String paymentStatus;
    
    @ManyToOne
    private Faculty faculty;


    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Faculty getCourse() {
        return course;
    }

    public void setCourse(Faculty course) {
        this.course = course;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

	public void setCourse(Course c) {
		// TODO Auto-generated method stub
		
	}

   
}