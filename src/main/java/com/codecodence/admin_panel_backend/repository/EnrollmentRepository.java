package com.codecodence.admin_panel_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	List<Enrollment> findByStudentId(Long studentId);

}
