package com.tientt.springmvc.validator.annotation;


import com.tientt.springmvc.validator.ConfirmPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPasswordNotMatch {
    String message() default "Confirm password mismatch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
