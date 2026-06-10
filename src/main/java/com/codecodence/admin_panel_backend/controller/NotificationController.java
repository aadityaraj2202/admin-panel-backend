package com.codecodence.admin_panel_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import com.codecodence.admin_panel_backend.dto.NotificationDTO;
import com.codecodence.admin_panel_backend.entity.Notification;
import com.codecodence.admin_panel_backend.entity.Student;
import com.codecodence.admin_panel_backend.repository.NotificationRepository;
import com.codecodence.admin_panel_backend.repository.StudentRepository;
import com.codecodence.admin_panel_backend.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService notificationService;
    private final StudentRepository studentRepository;
    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationService notificationService,
                                  StudentRepository studentRepository,
                                  NotificationRepository notificationRepository) {

        this.notificationService = notificationService;
        this.studentRepository = studentRepository;
        this.notificationRepository = notificationRepository;
    }

    // Create notification
    @PostMapping
    public Notification createNotification(@RequestBody NotificationDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();

        Notification notification = new Notification();

        notification.setStudent(student);
        notification.setMessage(dto.getMessage());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReadStatus(false);

        return notificationService.save(notification);
    }

    // Get notifications of student
    @GetMapping("/student/{studentId}")
    public List<Notification> getStudentNotifications(@PathVariable Long studentId) {

        return notificationService.getStudentNotifications(studentId);
    }

    // Mark notification as read
    @PutMapping("/read/{id}")
    public Notification markAsRead(@PathVariable Long id) {

        Notification notification = notificationRepository.findById(id).orElseThrow();

        notification.setReadStatus(true);

        return notificationRepository.save(notification);
    }

    // Get all notifications
    @GetMapping
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }
}