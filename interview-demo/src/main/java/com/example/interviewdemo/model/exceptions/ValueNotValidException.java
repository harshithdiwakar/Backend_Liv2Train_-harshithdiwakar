package com.example.interviewdemo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "value entered is not valid")
public class ValueNotValidException extends RuntimeException {

    public ValueNotValidException(String message) {
        super(message);
    }
}
