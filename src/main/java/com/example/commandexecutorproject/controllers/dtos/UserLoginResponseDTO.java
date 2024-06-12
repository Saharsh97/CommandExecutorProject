package com.example.commandexecutorproject.controllers.dtos;

import com.example.commandexecutorproject.controllers.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDTO {
    private Long id;
    private ResponseStatus responseStatus;
    private String message;
}
