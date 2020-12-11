package com.tientt.springmvc.validator;

import com.tientt.springmvc.form.RegisterForm;
import com.tientt.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("registerValidator")
public class RegisterValidator implements Validator {

    RegistrationService registrationService;

    @Autowired
    public RegisterValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm registerForm = (RegisterForm) o;
   
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();
        String confirmPassword = registerForm.getConfirmPassword();
        String lastname = registerForm.getLastname();

        int usernameLength = username.length();
        int passwordLength = password.length();
        int lastnameLength = lastname.length();

        if (usernameLength < 6 || usernameLength > 20){
            errors.rejectValue("username", "username.length",
                    "username must be in 6 to 20 characters");
        } else if (registrationService.isUsernameExisted(username)){
            errors.rejectValue("username", "username.existed",
                    "username existed");
        }
        if (passwordLength < 8 || passwordLength > 30) {
            errors.rejectValue("password", "password.length",
                    "password must be in 8 to 30 characters");
        } else if (!password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "confirm.notmatch",
                    "confirm password not match");
        }
        if (lastnameLength < 2 || lastnameLength > 50) {
            errors.rejectValue("lastname", "lastname.length",
                    "lastname must be 2 to 50 character");
        }
    }
}
