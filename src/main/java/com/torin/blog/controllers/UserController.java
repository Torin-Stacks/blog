package com.torin.blog.controllers;

import com.torin.blog.dtos.CreateUserRequest;
import com.torin.blog.dtos.LoginRequest;
import com.torin.blog.exceptions.OurBlogException;
import com.torin.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserRequest createUserRequest) throws OurBlogException {
        userService.createUser(createUserRequest);
    }


    @PostMapping("login")
    public void login(@RequestBody LoginRequest loginRequest) throws OurBlogException {
        userService.login(loginRequest);
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email) throws OurBlogException {
        return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }

}
