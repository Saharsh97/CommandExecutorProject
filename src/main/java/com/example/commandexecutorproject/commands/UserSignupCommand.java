package com.example.commandexecutorproject.commands;

import com.example.commandexecutorproject.controllers.UserController;

public class UserSignupCommand implements Command {
    private UserController userController;

    public UserSignupCommand(UserController userController){
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
