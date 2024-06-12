package com.example.commandexecutorproject.services;

import com.example.commandexecutorproject.models.User;
import com.example.commandexecutorproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User login(String name){
        Optional<User> userOptional = userRepository.findUserByName(name);
        User user = User.builder()
                .name(name)
                .id(20L)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        return user;
    }
}
