package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.AssignmentSubmissionDTO;
import com.codecodence.admin_panel_backend.entity.AssignmentSubmission;
import com.codecodence.admin_panel_backend.entity.Assignment;
import com.codecodence.admin_panel_backend.entity.Student;
import com.codecodence.admin_panel_backend.repository.AssignmentRepository;
import com.codecodence.admin_panel_backend.repository.StudentRepository;
import com.codecodence.admin_panel_backend.service.AssignmentSubmissionService;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin(origins = "*")
public class AssignmentSubmissionController {

    private final AssignmentSubmissionService submissionService;
    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;

    public AssignmentSubmissionController(
            AssignmentSubmissionService submissionService,
            AssignmentRepository assignmentRepository,
            StudentRepository studentRepository) {

        this.submissionService = submissionService;
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    // Submit assignment
    @PostMapping
    public AssignmentSubmission submitAssignment(@RequestBody AssignmentSubmissionDTO dto) {

        Assignment assignment = assignmentRepository.findById(dto.getAssignmentId()).orElseThrow();

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();

        AssignmentSubmission submission = new AssignmentSubmission();

        submission.setAssignment(assignment);
        submission.setStudent(student);
        submission.setFileUrl(dto.getFileUrl());
        submission.setSubmittedAt(LocalDateTime.now());

        return submissionService.saveSubmission(submission);
    }

    // Get submissions by student
    @GetMapping("/student/{studentId}")
    public List<AssignmentSubmission> getStudentSubmissions(@PathVariable Long studentId) {
        return submissionService.getStudentSubmissions(studentId);
    }

}