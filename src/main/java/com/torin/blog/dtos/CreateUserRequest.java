package com.torin.blog.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    private String email;

    private String password;

    private String phoneNumber;
}
