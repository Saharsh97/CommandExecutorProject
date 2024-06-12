package com.example.commandexecutorproject.controllers;

import com.example.commandexecutorproject.controllers.dtos.UserLoginRequestDTO;
import com.example.commandexecutorproject.controllers.dtos.UserLoginResponseDTO;
import com.example.commandexecutorproject.controllers.enums.ResponseStatus;
import com.example.commandexecutorproject.models.User;
import com.example.commandexecutorproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        try {
            User user = userService.login(userLoginRequestDTO.getName());

            userLoginResponseDTO.setId(user.getId());
            userLoginResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            userLoginResponseDTO.setMessage("saved to DB");
        } catch (Exception e){
            userLoginResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            userLoginResponseDTO.setMessage("unable to save to DB");
        }
        return userLoginResponseDTO;
    }
}
