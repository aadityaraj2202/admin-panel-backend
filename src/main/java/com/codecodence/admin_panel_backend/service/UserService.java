package com.codecodence.admin_panel_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.codecodence.admin_panel_backend.dto.UserDTO;
import com.codecodence.admin_panel_backend.entity.User;
import com.codecodence.admin_panel_backend.entity.Role;
import com.codecodence.admin_panel_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Convert String -> Role safely
    private Role parseRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            return Role.STUDENT;
        }

        try {
            return Role.valueOf(role.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return Role.STUDENT;
        }
    }

    // Validate user input
    private void validateUser(UserDTO dto) {
        if (dto.getUserName() == null || dto.getUserName().trim().isEmpty()) {
            throw new IllegalArgumentException("userName is required");
        }
        if (dto.getUserEmail() == null || dto.getUserEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("userEmail is required");
        }
    }

    // 🔥 MAP METHOD (IMPORTANT ADDITION)
    private UserDTO mapToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        dto.setUserPhoneNumber(user.getUserPhoneNumber());
        dto.setRole(user.getRole().name());
        dto.setActive(user.getActive());

        return dto;
    }

    // Save single user
    public UserDTO saveUser(UserDTO dto) {

        validateUser(dto);

        User user = new User();
        user.setUserName(dto.getUserName().trim());
        user.setUserEmail(dto.getUserEmail().trim());
        user.setUserPassword(dto.getUserPassword() != null ? dto.getUserPassword() : "");
        user.setUserPhoneNumber(dto.getUserPhoneNumber());
        user.setRole(parseRole(dto.getRole()));
        user.setActive(dto.getActive() != null ? dto.getActive() : true);

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }

    // Save multiple users
    public List<UserDTO> saveMultipleUser(List<UserDTO> dtos) {

        List<User> users = dtos.stream().map(dto -> {

            validateUser(dto);

            User user = new User();
            user.setUserName(dto.getUserName().trim());
            user.setUserEmail(dto.getUserEmail().trim());
            user.setUserPassword(dto.getUserPassword() != null ? dto.getUserPassword() : "");
            user.setUserPhoneNumber(dto.getUserPhoneNumber());
            user.setRole(parseRole(dto.getRole()));
            user.setActive(dto.getActive() != null ? dto.getActive() : true);

            return user;

        }).collect(Collectors.toList());

        List<User> savedUsers = userRepository.saveAll(users);

        return savedUsers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get all users
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get user by ID
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return mapToDTO(user);
    }

    // Update user
    public UserDTO updateUser(Long id, UserDTO dto) {

        validateUser(dto);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setUserName(dto.getUserName().trim());
        user.setUserEmail(dto.getUserEmail().trim());
        user.setUserPassword(dto.getUserPassword() != null
                ? dto.getUserPassword()
                : user.getUserPassword());

        user.setUserPhoneNumber(dto.getUserPhoneNumber());
        user.setRole(parseRole(dto.getRole()));
        user.setActive(dto.getActive() != null
                ? dto.getActive()
                : user.getActive());

        User updatedUser = userRepository.save(user);

        return mapToDTO(updatedUser);
    }

    // 🔥 PROFILE METHOD (IMPORTANT)
    public UserDTO getUserByEmail(String email) {

        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}