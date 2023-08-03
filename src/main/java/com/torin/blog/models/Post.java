package com.torin.blog.models;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private String body;
    private int likes;
}
