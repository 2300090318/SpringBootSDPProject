package com.klef.sdp.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_table")
public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100, nullable = false)
    private String name;
    
    @Column(length = 50, nullable = false)
    private String grade;
    
   
    
    @Column(length = 100, nullable = false)
    private String location;
    
  
    @Column(length = 100, unique = true, nullable = false)
    private String email;
    
    @Column(length = 100, unique = true, nullable = false)
    private String password;
    
    @Column(length = 15, nullable = false)
    private String phone;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}