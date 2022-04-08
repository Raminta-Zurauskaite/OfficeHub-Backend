package com.example.demo.user.controller;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserEntity userEntity) {
        return new ResponseEntity(userService.saveUserEntity(userEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserEntity> fetchUsers() {
        return userService.getAllUsers().stream().map(p -> new UserEntity(p.getUser_id(), p.getName(), p.getSurname(), p.getEmail(), p.getPassword())).collect(Collectors.toList());
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity deleteUser(@PathVariable Long user_id){
        return new ResponseEntity(userService.deleteUser(user_id), HttpStatus.OK);
    }

}