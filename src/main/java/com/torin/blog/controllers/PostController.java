package com.torin.blog.controllers;

import com.torin.blog.dtos.PostRequest;
import com.torin.blog.exceptions.OurBlogException;
import com.torin.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("{email}")
    public ResponseEntity<?> post(@PathVariable String email, @RequestBody PostRequest postRequest) throws OurBlogException {
        return new ResponseEntity<>(postService.addPost(email, postRequest), HttpStatus.CREATED);
    }
}
