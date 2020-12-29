package com.tientt.springmvc.responsemodel;

import java.io.Serializable;

public class NewRegistrationResponseModel implements Serializable {
    private String username;
    private String lastname;
    private boolean role;

    public NewRegistrationResponseModel() {
    }

    public NewRegistrationResponseModel(String username, String lastname, boolean role) {
        this.username = username;
        this.lastname = lastname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
