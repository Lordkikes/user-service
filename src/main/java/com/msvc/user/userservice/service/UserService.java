package com.msvc.user.userservice.service;

import com.msvc.user.userservice.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity user);
    List<UserEntity> getAllUsers();
    UserEntity getUser(Long userId);
}
