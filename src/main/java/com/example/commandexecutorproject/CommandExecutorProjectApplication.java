package com.example.commandexecutorproject;

import com.example.commandexecutorproject.commands.*;
import com.example.commandexecutorproject.controllers.SettleUpController;
import com.example.commandexecutorproject.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CommandExecutorProjectApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public void run(String... args) throws Exception {
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.addCommand(new UserSignupCommand(userController));
        commandExecutor.addCommand(new UserLoginCommand(userController));
        commandExecutor.addCommand(new SettleUpUserCommand(settleUpController));
        commandExecutor.addCommand(new SettleUpGroupCommand(settleUpController));

        while(true){
            System.out.println("enter your input");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            commandExecutor.runApplicableCommands(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandExecutorProjectApplication.class, args);
    }
}
