package com.torin.blog.services;

import com.torin.blog.dtos.PostDto;
import com.torin.blog.dtos.PostRequest;
import com.torin.blog.exceptions.OurBlogException;

public interface PostService {
    PostDto addPost(String email, PostRequest postRequest) throws OurBlogException;
}
