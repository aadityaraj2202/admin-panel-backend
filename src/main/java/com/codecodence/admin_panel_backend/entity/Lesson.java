package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String videoUrl;
    private int lessonOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getVideoUrl() { return videoUrl; }
    public int getLessonOrder() { return lessonOrder; }
    public Courses getCourse() { return course; }

    public void setTitle(String title) { this.title = title; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public void setLessonOrder(int lessonOrder) { this.lessonOrder = lessonOrder; }
    public void setCourse(Courses course) { this.course = course; }
}