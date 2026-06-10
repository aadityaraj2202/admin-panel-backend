package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.codecodence.admin_panel_backend.entity.Enrollment;
import com.codecodence.admin_panel_backend.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
	
	 private final EnrollmentRepository enrollmentRepository;

	    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
	        this.enrollmentRepository = enrollmentRepository;
	    }

	    public List<Enrollment> getStudentCourses(Long studentId) {
	        return enrollmentRepository.findByStudentId(studentId);
	    }

	    public Enrollment save(Enrollment enrollment) {
	        return enrollmentRepository.save(enrollment);
	    }

}
