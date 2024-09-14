package br.edu.ifpb.domain.model.services;

import br.edu.ifpb.interfaces.service.*;

public class PetCareService extends ServiceDecorator {
    private static final double PET_CARE_COST = 60.0;

    public PetCareService(ServiceDecorator service) {
        super(service);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + PET_CARE_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Pet Care";
    }
}