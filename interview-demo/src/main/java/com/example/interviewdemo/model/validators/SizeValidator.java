package com.example.interviewdemo.model.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SizeValidationCheck.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SizeValidator {

    String message() default "value provided is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int size() default 0;
}
