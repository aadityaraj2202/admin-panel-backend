package com.codecodence.admin_panel_backend.dto;

public class CourseDTO {
	
	private Long id;
	private String courseName;
	private String desciption;
	private String duration;
	private double fees;
	
	public CourseDTO() {
		
	}

	public CourseDTO(Long id, String courseName, String desciption, String duration, double fees) {
		this.id = id;
		this.courseName = courseName;
		this.desciption = desciption;
		this.duration = duration;
		this.fees = fees;
	}
	
	public CourseDTO (com.codecodence.admin_panel_backend.entity.Courses course) {
		this.id = course.getId();
		this.courseName = course.getCourseName();
		this.desciption = course.getDesciption();
		this.duration = course.getDuration();
		this.fees = course.getFees();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	
	

}
