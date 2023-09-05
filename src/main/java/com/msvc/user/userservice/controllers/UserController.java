package com.msvc.user.userservice.controllers;

import com.msvc.user.userservice.entity.UserEntity;
import com.msvc.user.userservice.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userRequest){
        UserEntity userSave = userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long userId){
        UserEntity user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
