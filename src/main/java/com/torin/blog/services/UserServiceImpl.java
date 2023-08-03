package com.torin.blog.services;

import com.torin.blog.dtos.CreateUserRequest;
import com.torin.blog.dtos.LoginRequest;
import com.torin.blog.dtos.UserDto;
import com.torin.blog.exceptions.OurBlogException;
import com.torin.blog.models.User;
import com.torin.blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest createUserRequest) throws OurBlogException {
        Optional<User> existingUser = userRepository.findByEmail(createUserRequest.getEmail());
        if (existingUser.isPresent()) {
            throw new OurBlogException("user with email already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        BeanUtils.copyProperties(createUserRequest, user);
        userRepository.save(user);
    }

    @Override
    public void login(LoginRequest loginRequest) throws OurBlogException {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new OurBlogException("user with email does not exists", HttpStatus.BAD_REQUEST));
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new OurBlogException("password incorrect", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserDto getUser(String email) throws OurBlogException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new OurBlogException("user with email does not exists", HttpStatus.BAD_REQUEST));
        UserDto userDto = new UserDto();
//        UserDto userDto = UserDto.builder()
//                .id(user.getId())
//                .createdAt(user.getCreatedAt())
//                .email(user.getEmail())
//                .phoneNumber(user.getPhoneNumber())
//                .build();
//
//        UserDto userDto1 = new UserDto();
//        userDto1.setId();
//        userDto1.setEmail();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public long getUserId(String email) throws OurBlogException {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new OurBlogException("user with email does not exists", HttpStatus.BAD_REQUEST));
      return   userRepository.getUserIdByEmail(email).orElseThrow(() -> new OurBlogException("user with email does not exists", HttpStatus.BAD_REQUEST));
    }
}
