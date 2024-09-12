package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.*;

public class SpaService extends ServiceDecorator {
    private static final double SPA_COST = 50.0;

    public SpaService(ServiceComponent decoratedService) {
        super(decoratedService);
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription() + "Serviço de Spa";
    }

    @Override
    public double getCost() {
        return decoratedService.getCost() + SPA_COST;
    }
}