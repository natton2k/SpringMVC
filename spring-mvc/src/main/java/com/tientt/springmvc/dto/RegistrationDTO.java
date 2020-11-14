package com.tientt.springmvc.dto;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {
    private String username;
    private String password;
    private String lastname;
    private boolean admin;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password, String lastname, boolean admin) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
