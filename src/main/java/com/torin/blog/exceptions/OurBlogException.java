package com.torin.blog.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OurBlogException extends Exception{

    private HttpStatus status;


    public OurBlogException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
