package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.codecodence.admin_panel_backend.entity.Attendance;
import com.codecodence.admin_panel_backend.repository.AttendanceRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getStudentAttendance(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

}