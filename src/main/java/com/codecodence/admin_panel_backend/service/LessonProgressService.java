package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.codecodence.admin_panel_backend.entity.*;
import com.codecodence.admin_panel_backend.repository.*;

@Service
public class LessonProgressService {

    private final LessonProgressRepository progressRepository;
    private final LessonRepository lessonRepository;

    public LessonProgressService(LessonProgressRepository progressRepository,
                                 LessonRepository lessonRepository) {
        this.progressRepository = progressRepository;
        this.lessonRepository = lessonRepository;
    }

    // Save or Update Progress (IMPORTANT)
    public LessonProgress saveOrUpdateProgress(Student student, Lesson lesson, boolean completed) {

        Optional<LessonProgress> existing =
                progressRepository.findByStudentIdAndLessonId(student.getId(), lesson.getId());

        LessonProgress progress;

        if (existing.isPresent()) {
            // Update existing
            progress = existing.get();
            progress.setCompleted(completed);
        } else {
            // Create new
            progress = new LessonProgress();
            progress.setStudent(student);
            progress.setLesson(lesson);
            progress.setCompleted(completed);
        }

        return progressRepository.save(progress);
    }

    // Get all progress of student
    public List<LessonProgress> getStudentProgress(Long studentId) {
        return progressRepository.findByStudentId(studentId);
    }

    // Calculate progress %
    public double calculateProgress(Long studentId, Long courseId) {

        long completed = progressRepository
                .countByStudentIdAndLessonCourseIdAndCompletedTrue(studentId, courseId);

        long total = lessonRepository
                .findByCourseIdOrderByLessonOrderAsc(courseId)
                .size();

        if (total == 0) return 0;

        return (completed * 100.0) / total;
    }
}