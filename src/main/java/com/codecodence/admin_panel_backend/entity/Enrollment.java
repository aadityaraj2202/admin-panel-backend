package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "enrollments")

public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Courses courses;
	
	private int progress;
	
	private LocalDateTime enrolledAt;
	
	public Enrollment () {
		
	}

	public Enrollment (Student student, Courses course) {
		this.student = student;
		this.courses = course;
		this.enrolledAt = enrolledAt;
		this.progress = progress;
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

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public LocalDateTime getEnrolledAt() {
		return enrolledAt;
	}

	public void setEnrolledAt(LocalDateTime enrolledAt) {
		this.enrolledAt = enrolledAt;
	}

}
