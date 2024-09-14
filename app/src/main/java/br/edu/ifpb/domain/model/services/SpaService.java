package br.edu.ifpb.domain.model.services;

import br.edu.ifpb.interfaces.service.*;

public class SpaService extends ServiceDecorator {
    private final double SPA_COST = 50.0; 

    public SpaService(ServiceDecorator service) {
        super(service);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + SPA_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Servico de Spa";
    }
}
