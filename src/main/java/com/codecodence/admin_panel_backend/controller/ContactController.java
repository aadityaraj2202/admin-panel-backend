package com.codecodence.admin_panel_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codecodence.admin_panel_backend.dto.ContactRequest;
import com.codecodence.admin_panel_backend.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendForm(@RequestBody ContactRequest request) {

        String body = "🔥 New Lead Received 🔥\n\n"
                + "Name: " + request.getName() + "\n"
                + "Phone: " + request.getPhone() + "\n"
                + "Email: " + request.getEmail() + "\n"
                + "Status: " + request.getStatus() + "\n"
                + "Course: " + request.getCourse() + "\n"
                + "Experience: " + request.getExperience() + "\n"
                + "Goal: " + request.getGoal();

        emailService.sendEmail(
        	    "codecodence@gmail.com",
        	    "New Career Consultation Lead",
        	    body
        	);
        return "Email sent successfully!";
    }
}