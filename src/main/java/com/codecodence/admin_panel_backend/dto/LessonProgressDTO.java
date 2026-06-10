package com.codecodence.admin_panel_backend.dto;

public class LessonProgressDTO {

    private Long studentId;
    private Long lessonId;
    private boolean completed;

    public Long getStudentId() { return studentId; }
    public Long getLessonId() { return lessonId; }
    public boolean isCompleted() { return completed; }

    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setLessonId(Long lessonId) { this.lessonId = lessonId; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}