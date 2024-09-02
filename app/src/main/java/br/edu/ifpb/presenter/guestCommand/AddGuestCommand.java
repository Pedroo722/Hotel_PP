package br.edu.ifpb.presenter.guestCommand;

import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.domain.wrappers.CPF;
import br.edu.ifpb.domain.wrappers.Name;
import br.edu.ifpb.interfaces.Command;

public class AddGuestCommand implements Command {
    private GuestController guestController;
    private Name newName;
    private CPF newCpf;

    public AddGuestCommand(GuestController guestController, Name newName, CPF newCpf) {
        this.guestController = guestController;
        this.newName = newName;
        this.newCpf = newCpf;
    }

    @Override
    public void execute() {
        guestController.addGuest(newName, newCpf);
    }
}
