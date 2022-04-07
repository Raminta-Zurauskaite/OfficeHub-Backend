package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity saveUserEntity(UserEntity userEntity);

    List<UserEntity> getAllUsers();
}
