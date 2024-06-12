package com.example.commandexecutorproject.commands;

import com.example.commandexecutorproject.controllers.UserController;
import com.example.commandexecutorproject.controllers.dtos.UserLoginRequestDTO;
import com.example.commandexecutorproject.controllers.dtos.UserLoginResponseDTO;

public class UserLoginCommand implements Command{
    private UserController userController;

    public UserLoginCommand(UserController userController){
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words.length > 0 && words[0].equals("UserLogin");
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        if(words.length < 2) {
            return;
        }
        String name = words[1];
        UserLoginRequestDTO userLoginRequestDTO = new UserLoginRequestDTO();
        userLoginRequestDTO.setName(name);

        UserLoginResponseDTO userLoginResponseDTO = userController.login(userLoginRequestDTO);

        System.out.printf(userLoginResponseDTO.getId() + " : " + userLoginResponseDTO.getMessage());
    }
}
