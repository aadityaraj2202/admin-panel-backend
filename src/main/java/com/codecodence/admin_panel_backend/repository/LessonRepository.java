package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Lesson;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCourseIdOrderByLessonOrderAsc(Long courseId);

}