package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.Activity;
import com.codecodence.admin_panel_backend.repository.ActivityRepository;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public Activity saveActivity(Activity activity) {
        return repository.save(activity);
    }

    public List<Activity> getStudentActivities(Long studentId) {
        return repository.findByStudentId(studentId);
    }
}