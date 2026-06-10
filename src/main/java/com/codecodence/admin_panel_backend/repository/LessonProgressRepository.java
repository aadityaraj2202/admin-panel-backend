package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.LessonProgress;
import java.util.List;
import java.util.Optional;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {

    List<LessonProgress> findByStudentId(Long studentId);

    long countByStudentIdAndLessonCourseIdAndCompletedTrue(Long studentId, Long courseId);
    Optional<LessonProgress> findByStudentIdAndLessonId(Long studentId, Long lessonId);

}