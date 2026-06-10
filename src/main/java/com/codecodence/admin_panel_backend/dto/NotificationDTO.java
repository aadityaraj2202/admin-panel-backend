package com.codecodence.admin_panel_backend.dto;

public class NotificationDTO {

    private Long studentId;
    private String message;

    public Long getStudentId() {
        return studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}