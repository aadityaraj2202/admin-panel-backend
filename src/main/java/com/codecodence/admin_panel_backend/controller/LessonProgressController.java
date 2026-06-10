package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.LessonProgressDTO;
import com.codecodence.admin_panel_backend.entity.*;
import com.codecodence.admin_panel_backend.repository.*;
import com.codecodence.admin_panel_backend.service.LessonProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class LessonProgressController {

    private final LessonProgressService progressService;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public LessonProgressController(LessonProgressService progressService,
                                    StudentRepository studentRepository,
                                    LessonRepository lessonRepository) {
        this.progressService = progressService;
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    // Mark lesson complete/incomplete
    @PostMapping
    public LessonProgress markProgress(@RequestBody LessonProgressDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();
        Lesson lesson = lessonRepository.findById(dto.getLessonId()).orElseThrow();

        return progressService.saveOrUpdateProgress(
                student,
                lesson,
                dto.isCompleted()
        );
    }

    // Get all progress of student
    @GetMapping("/student/{studentId}")
    public List<LessonProgress> getStudentProgress(@PathVariable Long studentId) {
        return progressService.getStudentProgress(studentId);
    }

    // Get course progress %
    @GetMapping("/{studentId}/{courseId}")
    public double getCourseProgress(@PathVariable Long studentId,
                                   @PathVariable Long courseId) {

        return progressService.calculateProgress(studentId, courseId);
    }
}