package com.torin.blog.services;

import com.torin.blog.dtos.PostDto;
import com.torin.blog.dtos.PostRequest;
import com.torin.blog.exceptions.OurBlogException;
import com.torin.blog.models.Post;
import com.torin.blog.repositories.PostRepository;
import com.torin.blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserService userService;

    @Override
    public PostDto addPost(String email, PostRequest postRequest) throws OurBlogException {
        long userId = userService.getUserId(email);
        Post post = new Post();
        post.setBody(postRequest.getBody());
        post.setUserId(userId);
        Post savedPost = postRepository.save(post);
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(savedPost, postDto);
        return postDto;
    }
}
