package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.AssignmentDTO;
import com.codecodence.admin_panel_backend.entity.Assignment;
import com.codecodence.admin_panel_backend.entity.Courses;
import com.codecodence.admin_panel_backend.repository.CourseRepository;
import com.codecodence.admin_panel_backend.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final CourseRepository courseRepository;

    public AssignmentController(AssignmentService assignmentService,
                                CourseRepository courseRepository) {

        this.assignmentService = assignmentService;
        this.courseRepository = courseRepository;
    }

    // Create assignment
    @PostMapping
    public Assignment createAssignment(@RequestBody AssignmentDTO dto) {

        Courses course = courseRepository.findById(dto.getCourseId()).orElseThrow();

        Assignment assignment = new Assignment();

        assignment.setTitle(dto.getTitle());
        assignment.setDescription(dto.getDescription());
        assignment.setDueDate(dto.getDueDate());
        assignment.setCourse(course);

        return assignmentService.saveAssignment(assignment);
    }

    // Get assignments of course
    @GetMapping("/course/{courseId}")
    public List<Assignment> getAssignmentsByCourse(@PathVariable Long courseId) {
        return assignmentService.getAssignmentsByCourse(courseId);
    }

    // Get all assignments
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }
}