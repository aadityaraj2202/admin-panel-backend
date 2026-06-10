package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;
import com.codecodence.admin_panel_backend.entity.Role;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userEmail;
    private String userPassword;
    private Long userPhoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active = true;

    public User() {}

    public User(Long id, String userName, String userEmail, String userPassword,
                Long userPhoneNumber, Role role, Boolean active) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.role = role;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public Long getUserPhoneNumber() { return userPhoneNumber; }
    public void setUserPhoneNumber(Long userPhoneNumber) { this.userPhoneNumber = userPhoneNumber; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}