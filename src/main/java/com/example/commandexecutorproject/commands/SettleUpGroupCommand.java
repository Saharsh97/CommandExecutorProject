package com.example.commandexecutorproject.commands;

import com.example.commandexecutorproject.controllers.SettleUpController;

public class SettleUpGroupCommand implements Command {
    private SettleUpController settleUpController;

    public SettleUpGroupCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
