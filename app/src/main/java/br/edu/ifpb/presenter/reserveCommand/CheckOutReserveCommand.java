package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.domain.wrappers.*;

public class CheckOutReserveCommand implements Command {
    private ReserveController reserveController;
    private Id reserveId;

    public CheckOutReserveCommand(ReserveController reserveController, Id reserveId) {
        this.reserveController = reserveController;
        this.reserveId = reserveId;
    }

    @Override
    public void execute() {
        reserveController.checkOut(reserveId);
    }
}
