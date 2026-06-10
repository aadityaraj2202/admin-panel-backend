package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long>{

}
