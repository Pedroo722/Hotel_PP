package br.edu.ifpb.presenter.serviceCommand;

import br.edu.ifpb.presenter.controller.ServiceController;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.Command;

public class RemoveServiceCommand implements Command {
    private ServiceController serviceController;
    private Id id;

    public RemoveServiceCommand(ServiceController serviceController, Id id) {
        this.serviceController = serviceController;
        this.id = id;
    }

    @Override
    public void execute() {
        serviceController.removeService(id);
    }
}
