package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.*;
import com.codecodence.admin_panel_backend.repository.*;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonProgressRepository progressRepository;

    public LessonService(LessonRepository lessonRepository,
                         LessonProgressRepository progressRepository) {
        this.lessonRepository = lessonRepository;
        this.progressRepository = progressRepository;
    }

    public List<Lesson> getCourseLessons(Long courseId) {
        return lessonRepository.findByCourseIdOrderByLessonOrderAsc(courseId);
    }

    public LessonProgress saveProgress(LessonProgress progress) {
        return progressRepository.save(progress);
    }

    public double calculateProgress(Long studentId, Long courseId) {

        long completed = progressRepository
                .countByStudentIdAndLessonCourseIdAndCompletedTrue(studentId, courseId);

        long total = lessonRepository.findByCourseIdOrderByLessonOrderAsc(courseId).size();

        if (total == 0) return 0;

        return (completed * 100.0) / total;
    }
}