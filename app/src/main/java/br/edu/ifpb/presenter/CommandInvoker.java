package br.edu.ifpb.presenter;

import br.edu.ifpb.interfaces.*;

public class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Nenhum comando definido.");
        }
    }
}
