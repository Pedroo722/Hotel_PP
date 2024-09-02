package br.edu.ifpb.presenter.reserveCommand;

import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.presenter.controller.*;

public class ListReservesCommand implements Command {
    private ReserveController reserveController;

    public ListReservesCommand(ReserveController reserveController) {
        this.reserveController = reserveController;
    }

    @Override
    public void execute() {
        reserveController.listReserves();
    }
}
