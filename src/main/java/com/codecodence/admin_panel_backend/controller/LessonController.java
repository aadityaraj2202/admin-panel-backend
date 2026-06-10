package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.*;
import com.codecodence.admin_panel_backend.entity.*;
import com.codecodence.admin_panel_backend.repository.*;
import com.codecodence.admin_panel_backend.service.LessonService;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService lessonService;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public LessonController(LessonService lessonService,
                            CourseRepository courseRepository,
                            StudentRepository studentRepository,
                            LessonRepository lessonRepository) {
        this.lessonService = lessonService;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    // Create Lesson
    @PostMapping
    public Lesson createLesson(@RequestBody LessonDTO dto) {

        Courses course = courseRepository.findById(dto.getCourseId()).orElseThrow();

        Lesson lesson = new Lesson();
        lesson.setTitle(dto.getTitle());
        lesson.setVideoUrl(dto.getVideoUrl());
        lesson.setLessonOrder(dto.getLessonOrder());
        lesson.setCourse(course);

        return lessonRepository.save(lesson);
    }

    // Get lessons of course
    @GetMapping("/course/{courseId}")
    public List<Lesson> getLessons(@PathVariable Long courseId) {
        return lessonService.getCourseLessons(courseId);
    }

    // Mark lesson complete
    @PostMapping("/progress")
    public LessonProgress markProgress(@RequestBody LessonProgressDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();
        Lesson lesson = lessonRepository.findById(dto.getLessonId()).orElseThrow();

        LessonProgress progress = new LessonProgress();
        progress.setStudent(student);
        progress.setLesson(lesson);
        progress.setCompleted(dto.isCompleted());

        return lessonService.saveProgress(progress);
    }

    // Get course progress %
    @GetMapping("/progress/{studentId}/{courseId}")
    public double getProgress(@PathVariable Long studentId,
                             @PathVariable Long courseId) {

        return lessonService.calculateProgress(studentId, courseId);
    }
}