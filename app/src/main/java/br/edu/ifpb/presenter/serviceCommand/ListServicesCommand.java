package br.edu.ifpb.presenter.serviceCommand;

import br.edu.ifpb.presenter.controller.ServiceController;
import br.edu.ifpb.interfaces.Command;

public class ListServicesCommand implements Command {
    private ServiceController serviceController;

    public ListServicesCommand(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public void execute() {
        serviceController.listServices();
    }
}
