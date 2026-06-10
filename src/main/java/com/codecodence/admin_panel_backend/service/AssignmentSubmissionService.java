package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.AssignmentSubmission;
import com.codecodence.admin_panel_backend.repository.AssignmentSubmissionRepository;

@Service
public class AssignmentSubmissionService {

    private final AssignmentSubmissionRepository repository;

    public AssignmentSubmissionService(AssignmentSubmissionRepository repository) {
        this.repository = repository;
    }

    public AssignmentSubmission saveSubmission(AssignmentSubmission submission) {
        return repository.save(submission);
    }

    public List<AssignmentSubmission> getStudentSubmissions(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    public List<AssignmentSubmission> getAssignmentSubmissions(Long assignmentId) {
        return repository.findByAssignmentId(assignmentId);
    }

}