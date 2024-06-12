package com.example.commandexecutorproject.commands;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
