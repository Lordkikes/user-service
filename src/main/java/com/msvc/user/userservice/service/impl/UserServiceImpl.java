package com.msvc.user.userservice.service.impl;

import com.msvc.user.userservice.entity.UserEntity;
import com.msvc.user.userservice.exception.ResourceNotFoundException;
import com.msvc.user.userservice.repository.UserRepository;
import com.msvc.user.userservice.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserEntity saveUser(UserEntity user) {

        String randomUser = UUID.randomUUID().toString();
        user.setUserId(randomUser);
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                "User not found whit Id: " + userId
        ));
    }
}
