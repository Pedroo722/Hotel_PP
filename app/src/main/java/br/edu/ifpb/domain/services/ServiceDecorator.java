package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.*;

public abstract class ServiceDecorator implements ServiceComponent {
    protected ServiceComponent decoratedService;

    public ServiceDecorator(ServiceComponent decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedService.getCost();
    }
}
