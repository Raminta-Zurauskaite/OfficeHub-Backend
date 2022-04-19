package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    UserEntity saveUserEntity(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    String deleteUser(Integer userID);
}
