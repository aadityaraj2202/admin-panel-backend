package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
