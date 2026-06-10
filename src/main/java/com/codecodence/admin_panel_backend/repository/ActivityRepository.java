package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Activity;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByStudentId(Long studentId);

}