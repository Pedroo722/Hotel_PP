package br.edu.ifpb.presenter.serviceCommand;

import br.edu.ifpb.presenter.controller.ServiceController;
import br.edu.ifpb.domain.model.Service;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.Command;

public class EditServiceCommand implements Command {
    private ServiceController serviceController;
    private Id id;
    private Service service;

    public EditServiceCommand(ServiceController serviceController, Service service) {
        this.serviceController = serviceController;
        this.service = service;
    }

    @Override
    public void execute() {
        serviceController.editService(id, service);
    }
}
