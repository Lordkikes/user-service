package com.msvc.user.userservice.service.impl;

import com.msvc.user.userservice.entity.UserEntity;
import com.msvc.user.userservice.exceptions.ResourceNotFoundException;
import com.msvc.user.userservice.repository.UserRepository;
import com.msvc.user.userservice.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity saveUser(UserEntity userEntity) {

        //Long randomUserId = Long.valueOf(UUID.randomUUID().toString());
       // userEntity.setUserId();
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                "User not found whit Id: " + userId
        ));
    }
}
