package com.codecodence.admin_panel_backend.dto;

import java.util.List;

public class StudentDashboardDTO {

    private List<?> courses;
    private double progress;
    private double attendance;
    private List<?> upcomingClasses;
    private List<?> assignments;
    private List<?> activities;
    private List<?> notifications;

    public List<?> getCourses() { return courses; }
    public double getProgress() { return progress; }
    public double getAttendance() { return attendance; }
    public List<?> getUpcomingClasses() { return upcomingClasses; }
    public List<?> getAssignments() { return assignments; }
    public List<?> getActivities() { return activities; }
    public List<?> getNotifications() { return notifications; }

    public void setCourses(List<?> courses) { this.courses = courses; }
    public void setProgress(double progress) { this.progress = progress; }
    public void setAttendance(double attendance) { this.attendance = attendance; }
    public void setUpcomingClasses(List<?> upcomingClasses) { this.upcomingClasses = upcomingClasses; }
    public void setAssignments(List<?> assignments) { this.assignments = assignments; }
    public void setActivities(List<?> activities) { this.activities = activities; }
    public void setNotifications(List<?> notifications) { this.notifications = notifications; }
}