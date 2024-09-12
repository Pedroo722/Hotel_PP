package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.ServiceComponent;

public class PetCareService extends ServiceDecorator {
    private static final double PET_CARE_COST = 60.0;

    public PetCareService(ServiceComponent decoratedService) {
        super(decoratedService);
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription() + "Serviço de Pet Care";
    }

    @Override
    public double getCost() {
        return decoratedService.getCost() + PET_CARE_COST;
    }
}
