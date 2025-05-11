package com.klef.sdp.springboot.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_table")
public class Course 
{
	@Id
	@Column
	private int courseid;
	@Column(length = 50,nullable = false,unique = true)
	private String coursename;
	@Column(length = 5000,nullable = false)
	private String courseDescription;
	
	    @ManyToOne
	    @JoinColumn(name = "faculty_id", nullable = false)
	    private Faculty faculty;
		

	
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
	
	
	

}
