package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.domain.wrappers.*;

public class AddReserveCommand implements Command {
    private ReserveController reserveController;
    private Id guestId;
    private RoomNumber roomNumber;

    public AddReserveCommand(ReserveController reserveController, Id guestId, RoomNumber roomNumber) {
        this.reserveController = reserveController;
        this.guestId = guestId;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        reserveController.addReserve(guestId, roomNumber);
    }
}
