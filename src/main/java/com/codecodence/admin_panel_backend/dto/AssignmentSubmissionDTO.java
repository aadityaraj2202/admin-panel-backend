package com.codecodence.admin_panel_backend.dto;

public class AssignmentSubmissionDTO {

    private Long assignmentId;
    private Long studentId;
    private String fileUrl;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}