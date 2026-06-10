package com.codecodence.admin_panel_backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codecodence.admin_panel_backend.repository.CourseRepository;
import com.codecodence.admin_panel_backend.repository.StudentRepository;
import com.codecodence.admin_panel_backend.repository.TrainerRepository;
import com.codecodence.admin_panel_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final StudentRepository studentRepository;
    private final TrainerRepository trainerRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public DashboardController(StudentRepository studentRepository,
                               TrainerRepository trainerRepository,
                               CourseRepository courseRepository,
                               UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.trainerRepository = trainerRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Map<String, Long> getDashboardStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalStudents", studentRepository.count());
        stats.put("totalTrainers", trainerRepository.count());
        stats.put("totalCourses", courseRepository.count());
        stats.put("totalUsers", userRepository.count());

        return stats;
    }
}