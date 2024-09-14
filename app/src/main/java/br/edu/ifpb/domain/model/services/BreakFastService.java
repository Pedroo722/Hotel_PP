package br.edu.ifpb.domain.model.services;

import br.edu.ifpb.interfaces.service.*;

public class BreakFastService extends ServiceDecorator {
    private final double BREAK_FAST_COST = 30.0; 

    public BreakFastService(ServiceDecorator service) {
        super(service);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + BREAK_FAST_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Café da manhã";
    }
}
