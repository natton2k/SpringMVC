package com.tientt.springmvc.request;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class UpdateUserRequest implements Serializable {
    private String username;
    @Length(min = 8, max = 30, message = "Password is required 8 to 30")
    private String password;
    @Length(min = 2, max = 50, message = "Last name is required 2 to 50")
    private String lastname;
    private boolean admin;

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
