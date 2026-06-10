package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson_progress")
public class LessonProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Long getId() { return id; }
    public boolean isCompleted() { return completed; }
    public Student getStudent() { return student; }
    public Lesson getLesson() { return lesson; }

    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setStudent(Student student) { this.student = student; }
    public void setLesson(Lesson lesson) { this.lesson = lesson; }
}