package com.torin.blog.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(OurBlogException.class)
    public ResponseEntity<?> handleOUrBlogException(OurBlogException ourBlogException){
        return new ResponseEntity<>( ourBlogException.getMessage(), ourBlogException.getStatus());
    }
}
