package com.torin.blog.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDto {
    private String body;

    private long userId;

    private int likes;
}
