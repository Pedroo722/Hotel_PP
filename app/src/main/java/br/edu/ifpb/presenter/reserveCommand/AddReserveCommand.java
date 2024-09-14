package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.domain.wrappers.*;

public class AddReserveCommand implements Command {
    private ReserveController reserveController;
    private Id guestId;
    private RoomNumber roomNumber;
    private Id serviceId;

    public AddReserveCommand(ReserveController reserveController, Id guestId, RoomNumber roomNumber, Id serviceId) {
        this.reserveController = reserveController;
        this.guestId = guestId;
        this.roomNumber = roomNumber;
        this.serviceId = serviceId;
    }

    @Override
    public void execute() {
        reserveController.addReserve(guestId, roomNumber, serviceId);
    }
}
