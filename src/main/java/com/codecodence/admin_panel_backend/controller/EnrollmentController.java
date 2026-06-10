package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.codecodence.admin_panel_backend.entity.Enrollment;
import com.codecodence.admin_panel_backend.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // get courses of a student
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getStudentCourses(@PathVariable Long studentId) {
        return enrollmentService.getStudentCourses(studentId);
    }

    // enroll student
    @PostMapping
    public Enrollment enroll(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }
}