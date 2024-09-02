package br.edu.ifpb.presenter.guestCommand;

import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.*;

public class RemoveGuestCommand implements Command {
    private GuestController guestController;
    private Id id;

    public RemoveGuestCommand(GuestController guestController, Id id) {
        this.guestController = guestController;
        this.id = id;
    }

    @Override
    public void execute() {
        guestController.removeGuest(id);
    }
}
