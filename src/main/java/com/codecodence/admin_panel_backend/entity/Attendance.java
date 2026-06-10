package com.codecodence.admin_panel_backend.entity;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.*;
@Entity
@Table(name = "attendance")

public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "student_name")
	private Courses course;
	private LocalDate date;
	private String status;
	
	public Attendance () {
		
	}

	public Attendance(Long id, Student student, Courses course, LocalDate date, String status) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	

}
