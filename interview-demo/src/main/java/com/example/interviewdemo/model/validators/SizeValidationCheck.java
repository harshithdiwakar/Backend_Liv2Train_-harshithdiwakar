package com.example.interviewdemo.model.validators;

import com.example.interviewdemo.model.exceptions.ValueNotValidException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class SizeValidationCheck implements ConstraintValidator<SizeValidator, String> {

    private int size;
    private String message;

    @Override
    public void initialize(SizeValidator constraint) {
        this.size = constraint.size();
        this.message = constraint.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() == this.size) return true;
        else throw new ValueNotValidException(this.message);
    }
}
