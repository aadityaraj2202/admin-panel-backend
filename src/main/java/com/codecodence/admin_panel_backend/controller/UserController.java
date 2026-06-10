package com.codecodence.admin_panel_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.codecodence.admin_panel_backend.dto.UserDTO;
import com.codecodence.admin_panel_backend.service.UserService;
import com.codecodence.admin_panel_backend.security.JwtUtil;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil; // 🔥 ADD THIS

    // 🔥 CONSTRUCTOR UPDATE
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // CREATE
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return userService.saveUser(dto);
    }

    // BULK CREATE
    @PostMapping("/bulk")
    public List<UserDTO> createMultipleUser(@RequestBody List<UserDTO> dtos) {
        return userService.saveMultipleUser(dtos);
    }

    // GET ALL
    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserDTO updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {
        return userService.updateUser(id, dto);
    }

    // 🔥 PROFILE API (FINAL FIXED)
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String token) {

        String jwt = token.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(jwt);

        UserDTO user = userService.getUserByEmail(email);

        return ResponseEntity.ok(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}