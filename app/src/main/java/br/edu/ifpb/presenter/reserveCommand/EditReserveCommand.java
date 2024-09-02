package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.domain.wrappers.*;

public class EditReserveCommand implements Command {
    private ReserveController reserveController;
    private Id reserveId;
    private Id newGuestId;
    private RoomNumber newRoomNumber;

    public EditReserveCommand(ReserveController reserveController, Id reserveId, Id newGuestId, RoomNumber newRoomNumber) {
        this.reserveController = reserveController;
        this.reserveId = reserveId;
        this.newGuestId = newGuestId;
        this.newRoomNumber = newRoomNumber;
    }

    @Override
    public void execute() {
        reserveController.editReserve(reserveId, newGuestId, newRoomNumber);
    }
}