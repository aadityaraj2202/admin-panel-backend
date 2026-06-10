package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.Assignment;
import com.codecodence.admin_panel_backend.repository.AssignmentRepository;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}