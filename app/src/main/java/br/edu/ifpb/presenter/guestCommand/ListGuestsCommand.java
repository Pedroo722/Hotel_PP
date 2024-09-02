package br.edu.ifpb.presenter.guestCommand;

import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.interfaces.Command;

public class ListGuestsCommand implements Command {
    private GuestController guestController;

    public ListGuestsCommand(GuestController guestController) {
        this.guestController = guestController;
    }

    @Override
    public void execute() {
        guestController.listGuests();
    }
}
