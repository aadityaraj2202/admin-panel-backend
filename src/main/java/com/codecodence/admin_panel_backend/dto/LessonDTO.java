package com.codecodence.admin_panel_backend.dto;

public class LessonDTO {

    private Long courseId;
    private String title;
    private String videoUrl;
    private int lessonOrder;

    public Long getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public String getVideoUrl() { return videoUrl; }
    public int getLessonOrder() { return lessonOrder; }

    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public void setTitle(String title) { this.title = title; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public void setLessonOrder(int lessonOrder) { this.lessonOrder = lessonOrder; }
}