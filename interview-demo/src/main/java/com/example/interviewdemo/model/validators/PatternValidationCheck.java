package com.example.interviewdemo.model.validators;

import com.example.interviewdemo.model.exceptions.ValueNotValidException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidationCheck implements ConstraintValidator<PatternValidator, String> {

    private Pattern pattern;
    private String message;

    @Override
    public void initialize(PatternValidator constraint) {
        this.pattern = Pattern.compile(constraint.pattern());
        this.message = constraint.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher m = pattern.matcher(s);
        if (m.matches()) return true;
        else throw new ValueNotValidException(this.message);
    }
}
