package com.codecodence.admin_panel_backend.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codecodence.admin_panel_backend.dto.LoginRequest;
import com.codecodence.admin_panel_backend.dto.SignUpRequest;
import com.codecodence.admin_panel_backend.entity.Role;
import com.codecodence.admin_panel_backend.entity.User;
import com.codecodence.admin_panel_backend.repository.UserRepository;
import com.codecodence.admin_panel_backend.security.JwtUtil;

@Service
public class AuthService {


private final UserRepository userRepository;
private final BCryptPasswordEncoder passwordEncoder;
private final JwtUtil jwtUtil;

@Autowired
public AuthService(
        UserRepository userRepository,
        BCryptPasswordEncoder passwordEncoder,
        JwtUtil jwtUtil) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
}

// =========================
// SIGNUP
// =========================
public String registerUser(SignUpRequest request) {

    if (userRepository.existsByUserEmail(request.getEmail())) {
        return "Email already exists";
    }

    User user = new User();

    user.setUserName(request.getName());
    user.setUserEmail(request.getEmail());

    // BCrypt Password Encode
    user.setUserPassword(
            passwordEncoder.encode(request.getPassword()));

    user.setRole(Role.STUDENT);
    user.setActive(true);

    userRepository.save(user);

    return "User registered successfully";
}

// =========================
// LOGIN
// =========================
public Map<String, Object> login(LoginRequest request) {

    System.out.println("================================");
    System.out.println("LOGIN REQUEST");
    System.out.println("EMAIL = " + request.getEmail());
    System.out.println("PASSWORD = " + request.getPassword());

    User user = userRepository
            .findByUserEmail(request.getEmail())
            .orElseThrow(() ->
                    new RuntimeException("Invalid email or password"));

    System.out.println("DB EMAIL = " + user.getUserEmail());
    System.out.println("DB HASH = " + user.getUserPassword());

    boolean match = passwordEncoder.matches(
            request.getPassword(),
            user.getUserPassword());

    System.out.println("PASSWORD MATCH = " + match);

    if (!match) {
        throw new RuntimeException("Invalid email or password");
    }

    String token =
            jwtUtil.generateToken(user.getUserEmail());

    System.out.println("LOGIN SUCCESS");
    System.out.println("ROLE = " + user.getRole());

    return Map.of(
            "token", token,
            "role", user.getRole().name().toLowerCase(),
            "email", user.getUserEmail(),
            "name", user.getUserName()
    );
}


}
