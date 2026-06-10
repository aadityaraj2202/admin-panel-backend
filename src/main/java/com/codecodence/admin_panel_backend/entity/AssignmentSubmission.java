package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_submissions")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String fileUrl;

    private LocalDateTime submittedAt;

    private Integer grade;

    public AssignmentSubmission() {}

    public Long getId() {
        return id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public Student getStudent() {
        return student;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}