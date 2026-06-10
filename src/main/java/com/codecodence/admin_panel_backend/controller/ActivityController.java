package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.ActivityDTO;
import com.codecodence.admin_panel_backend.entity.Activity;
import com.codecodence.admin_panel_backend.entity.Student;
import com.codecodence.admin_panel_backend.repository.StudentRepository;
import com.codecodence.admin_panel_backend.service.ActivityService;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService activityService;
    private final StudentRepository studentRepository;

    public ActivityController(ActivityService activityService,
                              StudentRepository studentRepository) {
        this.activityService = activityService;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Activity createActivity(@RequestBody ActivityDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();

        Activity activity = new Activity();

        activity.setStudent(student);
        activity.setMessage(dto.getMessage());
        activity.setCreatedAt(LocalDateTime.now());

        return activityService.saveActivity(activity);
    }

    @GetMapping("/student/{studentId}")
    public List<Activity> getStudentActivities(@PathVariable Long studentId) {
        return activityService.getStudentActivities(studentId);
    }
}