package com.torin.blog.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends Exception {

    HttpStatus httpStatus;
    public EntityNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
