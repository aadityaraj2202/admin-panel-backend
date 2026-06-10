package com.codecodence.admin_panel_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.codecodence.admin_panel_backend.entity.Notification;
import com.codecodence.admin_panel_backend.repository.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> getStudentNotifications(Long studentId) {
        return repository.findByStudentId(studentId);
    }
}