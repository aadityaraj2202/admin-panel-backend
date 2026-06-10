package com.codecodence.admin_panel_backend.dto;

import com.codecodence.admin_panel_backend.entity.User;

public class UserDTO {

    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Long userPhoneNumber;
    private String role;
    private Boolean active = true;

    public UserDTO() {}

    public UserDTO(Long id, String userName, String userEmail, String userPassword,
                   Long userPhoneNumber, String role, Boolean active) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.role = role;
        this.active = active;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.userPassword = user.getUserPassword();
        this.userPhoneNumber = user.getUserPhoneNumber();
        this.role = user.getRole() != null ? user.getRole().name() : null;
        this.active = user.getActive();
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

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}