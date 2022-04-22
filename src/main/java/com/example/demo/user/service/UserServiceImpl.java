package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUserEntity(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Integer userID){
        userRepository.deleteById(userID);
        return "Deleted";
    }
}