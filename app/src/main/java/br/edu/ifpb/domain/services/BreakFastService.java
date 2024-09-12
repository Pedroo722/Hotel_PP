package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.ServiceComponent;

public class BreakFastService extends ServiceDecorator {
    private static final double BREAKFAST_COST = 15.0;

    public BreakFastService(ServiceComponent decoratedService) {
        super(decoratedService);
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription() + "Serviço de Café da Manhã";
    }

    @Override
    public double getCost() {
        return decoratedService.getCost() + BREAKFAST_COST;
    }
}
