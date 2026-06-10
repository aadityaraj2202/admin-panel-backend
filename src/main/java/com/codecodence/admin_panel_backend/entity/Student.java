package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "StudentName")
    private String studentName;
    @Column(name = "StudentEmail")
    private String studentEmail;
    @Column(name = "Courses")
    private String courses;
    @Column(name = "PhoneNumber")
    private Long phoneNumber;
    @Column(name = "Address")
    private String address;

    public Student() {
    	
    }

    public Student(Long id, String studentName, String studentEmail,
                   String courses, Long phoneNumber, String address) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.courses = courses;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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
    
    public String setAddress(String address) {
    	return address;
    }
}
