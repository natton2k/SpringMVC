package com.tientt.springmvc.validator;

import com.tientt.springmvc.form.RegisterForm;
import com.tientt.springmvc.validator.annotation.ConfirmPasswordNotMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPasswordNotMatch, RegisterForm> {
    @Override
    public void initialize(ConfirmPasswordNotMatch constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegisterForm value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmPassword());
    }
}
