// EditGuestCommand.java
package br.edu.ifpb.presenter.guestCommand;

import br.edu.ifpb.domain.wrappers.CPF;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.domain.wrappers.Name;
import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.interfaces.Command;

public class EditGuestCommand implements Command {
    private GuestController guestController;
    private Id id;
    private Name newName;
    private CPF newCpf;

    public EditGuestCommand(GuestController guestController, Id id, Name newName, CPF newCpf) {
        this.guestController = guestController;
        this.id = id;
        this.newName = newName;
        this.newCpf = newCpf;
    }

    @Override
    public void execute() {
        guestController.editGuest(id, newName, newCpf);
    }
}
