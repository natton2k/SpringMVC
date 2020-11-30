package com.tientt.springmvc.validator.annotation;

import com.tientt.springmvc.validator.ConfirmPasswordValidator;
import com.tientt.springmvc.validator.UsernameExistedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameExistedValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameExisted {
    String message() default "Username is existed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
