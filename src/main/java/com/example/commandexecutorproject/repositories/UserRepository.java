package com.example.commandexecutorproject.repositories;

import com.example.commandexecutorproject.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> findUserByName(String name){
        return Optional.empty();
    }
}
