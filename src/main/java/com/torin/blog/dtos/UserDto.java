package com.torin.blog.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
//@Builder
public class UserDto {

    private Date createdAt;

    private String email;

    private String phoneNumber;
}
