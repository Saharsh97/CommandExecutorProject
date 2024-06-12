package com.example.commandexecutorproject.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class User extends BaseModel {
    private String name;
}
