package com.codecodence.admin_panel_backend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClassScheduleDTO {

    private Long courseId;
    private Long trainerId;

    private String title;
    private LocalDate date;
    private LocalTime time;
    private String meetingLink;

    public Long getCourseId() {
        return courseId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }
}