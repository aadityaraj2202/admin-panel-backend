package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.codecodence.admin_panel_backend.dto.AttendanceDTO;
import com.codecodence.admin_panel_backend.entity.Attendance;
import com.codecodence.admin_panel_backend.entity.Student;
import com.codecodence.admin_panel_backend.entity.Courses;
import com.codecodence.admin_panel_backend.repository.StudentRepository;
import com.codecodence.admin_panel_backend.repository.CourseRepository;
import com.codecodence.admin_panel_backend.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public AttendanceController(
            AttendanceService attendanceService,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.attendanceService = attendanceService;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Mark attendance
    @PostMapping
    public Attendance markAttendance(@RequestBody AttendanceDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();

        Courses course = courseRepository.findById(dto.getCourseId()).orElseThrow();

        Attendance attendance = new Attendance();

        attendance.setStudent(student);
        attendance.setCourse(course);
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());

        return attendanceService.saveAttendance(attendance);
    }

    // Get student attendance
    @GetMapping("/student/{studentId}")
    public List<Attendance> getStudentAttendance(@PathVariable Long studentId) {
        return attendanceService.getStudentAttendance(studentId);
    }
}