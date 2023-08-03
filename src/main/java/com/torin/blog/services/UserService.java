package com.torin.blog.services;

import com.torin.blog.dtos.CreateUserRequest;
import com.torin.blog.dtos.LoginRequest;
import com.torin.blog.dtos.UserDto;
import com.torin.blog.exceptions.OurBlogException;

public interface UserService {

    void createUser(CreateUserRequest createUserRequest) throws OurBlogException;

    void login(LoginRequest loginRequest) throws OurBlogException;

    UserDto getUser(String email) throws OurBlogException;

    long getUserId(String email) throws OurBlogException;
}
