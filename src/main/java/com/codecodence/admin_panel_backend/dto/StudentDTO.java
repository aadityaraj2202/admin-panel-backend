package com.codecodence.admin_panel_backend.dto;

public class StudentDTO {
	
	    private Long id;
	    private String studentName;
	    private String studentEmail;
	    private String courses;
	    private Long phoneNumber;
	    private String address;

	    // Default Constructor
	    public StudentDTO() {}

	    // Constructor using fields
	    public StudentDTO(Long id, String studentName, String studentEmail,
	                      String courses, Long phoneNumber, String address) {
	        this.id = id;
	        this.studentName = studentName;
	        this.studentEmail = studentEmail;
	        this.courses = courses;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }

	    // Constructor from Entity
	    public StudentDTO(
	            com.codecodence.admin_panel_backend.entity.Student student) {
	        this.id = student.getId();
	        this.studentName = student.getStudentName();
	        this.studentEmail = student.getStudentEmail();
	        this.courses = student.getCourses();
	        this.phoneNumber = student.getPhoneNumber();
	        this.address = student.getAddress();
	    }

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getStudentName() {
	        return studentName;
	    }

	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }

	    public String getStudentEmail() {
	        return studentEmail;
	    }

	    public void setStudentEmail(String studentEmail) {
	        this.studentEmail = studentEmail;
	    }

	    public String getCourses() {
	        return courses;
	    }

	    public void setCourses(String courses) {
	        this.courses = courses;
	    }

	    public Long getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(Long phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

}
