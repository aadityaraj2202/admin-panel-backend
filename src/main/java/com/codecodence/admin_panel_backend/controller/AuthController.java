package com.codecodence.admin_panel_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codecodence.admin_panel_backend.dto.LoginRequest;
import com.codecodence.admin_panel_backend.dto.SignUpRequest;
import com.codecodence.admin_panel_backend.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpRequest request) {
        String response = authService.registerUser(request);
        return ResponseEntity.ok(
                Map.of("message", response)
        );
    }

    // ✅ LOGIN (FINAL FIX)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Map<String, Object> response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}