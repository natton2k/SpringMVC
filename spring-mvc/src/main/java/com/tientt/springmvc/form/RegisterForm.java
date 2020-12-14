package com.tientt.springmvc.form;

import com.tientt.springmvc.validator.annotation.ConfirmPasswordNotMatch;
import com.tientt.springmvc.validator.annotation.UsernameExisted;

import javax.validation.constraints.Size;
//@ConfirmPasswordNotMatch
public class RegisterForm {
    //@UsernameExisted
    //@Size(min = 6, max = 20)
    private String username;
    //@Size(min = 8, max = 20)
    private String password;
    private String confirmPassword;
    //@Size(min = 2, max = 50)
    private String lastname;

    public RegisterForm() {
    }

    public RegisterForm(String username, String password, String confirmPassword, String lastname) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastname = lastname;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
}
