package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.domain.wrappers.*;

public class RemoveReserveCommand implements Command {
    private ReserveController reserveController;
    private Id reserveId;

    public RemoveReserveCommand(ReserveController reserveController, Id reserveId) {
        this.reserveController = reserveController;
        this.reserveId = reserveId;
    }

    @Override
    public void execute() {
        reserveController.removeReserve(reserveId);
    }
}
