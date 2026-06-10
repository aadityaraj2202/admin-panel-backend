package com.codecodence.admin_panel_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
	List<Attendance> findByStudentId (Long StudentId);

}
