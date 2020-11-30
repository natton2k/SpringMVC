package com.tientt.springmvc.validator;

import com.tientt.springmvc.service.RegistrationService;
import com.tientt.springmvc.validator.annotation.UsernameExisted;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameExistedValidator implements ConstraintValidator<UsernameExisted, String> {
    @Autowired
    RegistrationService registrationService;
    @Override
    public void initialize(UsernameExisted constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !registrationService.isUsernameExisted(value);
    }
}
