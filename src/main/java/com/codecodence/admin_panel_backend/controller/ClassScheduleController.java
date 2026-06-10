package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.ClassScheduleDTO;
import com.codecodence.admin_panel_backend.entity.ClassSchedule;
import com.codecodence.admin_panel_backend.entity.Courses;
import com.codecodence.admin_panel_backend.entity.Trainer;
import com.codecodence.admin_panel_backend.repository.CourseRepository;
import com.codecodence.admin_panel_backend.repository.TrainerRepository;
import com.codecodence.admin_panel_backend.service.ClassScheduleService;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "*")
public class ClassScheduleController {

    private final ClassScheduleService scheduleService;
    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;

    public ClassScheduleController(
            ClassScheduleService scheduleService,
            CourseRepository courseRepository,
            TrainerRepository trainerRepository) {

        this.scheduleService = scheduleService;
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    // Create class schedule
    @PostMapping
    public ClassSchedule createSchedule(@RequestBody ClassScheduleDTO dto) {

        Courses course = courseRepository.findById(dto.getCourseId()).orElseThrow();
        Trainer trainer = trainerRepository.findById(dto.getTrainerId()).orElseThrow();

        ClassSchedule schedule = new ClassSchedule();

        schedule.setTitle(dto.getTitle());
        schedule.setDate(dto.getDate());
        schedule.setTime(dto.getTime());
        schedule.setMeetingLink(dto.getMeetingLink());
        schedule.setCourse(course);
        schedule.setTrainer(trainer);

        return scheduleService.saveSchedule(schedule);
    }

    // Get course schedule
    @GetMapping("/course/{courseId}")
    public List<ClassSchedule> getCourseSchedule(@PathVariable Long courseId) {
        return scheduleService.getCourseSchedule(courseId);
    }

    // Get all schedules
    @GetMapping
    public List<ClassSchedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
}