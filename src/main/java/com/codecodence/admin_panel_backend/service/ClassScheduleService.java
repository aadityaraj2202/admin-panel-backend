package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.ClassSchedule;
import com.codecodence.admin_panel_backend.repository.ClassScheduleRepository;

@Service
public class ClassScheduleService {

    private final ClassScheduleRepository repository;

    public ClassScheduleService(ClassScheduleRepository repository) {
        this.repository = repository;
    }

    public ClassSchedule saveSchedule(ClassSchedule schedule) {
        return repository.save(schedule);
    }

    public List<ClassSchedule> getCourseSchedule(Long courseId) {
        return repository.findByCourseId(courseId);
    }

    public List<ClassSchedule> getAllSchedules() {
        return repository.findAll();
    }
}