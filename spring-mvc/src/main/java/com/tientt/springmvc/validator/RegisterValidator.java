package com.tientt.springmvc.validator;

import com.tientt.springmvc.form.RegisterForm;
import com.tientt.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("registerValidator")
public class RegisterValidator implements Validator {

    @Autowired
    RegistrationService registrationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm registerForm = (RegisterForm) target;
        if (registerForm.getUsername().length() < 6 ||
                registerForm.getUsername().length() > 20) {
            errors.rejectValue("username", "username.length", "username must be in 6 to 20 characters");
        } else if (registrationService.isUsernameExisted(registerForm.getUsername())) {
            errors.rejectValue("username", "username.existed", "username existed");
        }
        if (registerForm.getPassword().length() < 8
                || registerForm.getPassword().length() > 30) {
            errors.rejectValue("password", "password.length", "password must be in 8 to 30 characters");
        } else if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirm.notmatch", "confirm password not match");
        }
        if (registerForm.getLastname().length() < 2 ||
                registerForm.getLastname().length() > 50) {
            errors.rejectValue("lastName", "lastname.length", "lastname must be 2 to 50 character");
        }


    }
}
