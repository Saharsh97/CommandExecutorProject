package com.example.commandexecutorproject.commands;

import com.example.commandexecutorproject.exceptions.CommandNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands;

    public CommandExecutor(){
        commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void runApplicableCommands(String input) throws CommandNotFoundException {
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                return;
            }
        }
        throw new CommandNotFoundException("command not found for given input : " + input);
    }
}
