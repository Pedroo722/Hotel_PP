package br.edu.ifpb.presenter.serviceCommand;

import br.edu.ifpb.domain.model.Service;
import br.edu.ifpb.presenter.controller.ServiceController;
import br.edu.ifpb.interfaces.Command;

public class AddServiceCommand implements Command {
    private ServiceController serviceController;
    private Service service;

    public AddServiceCommand(ServiceController serviceController, Service service) {
        this.serviceController = serviceController;
        this.service = service;
    }

    @Override
    public void execute() {
        serviceController.addService(service);
    }
}
