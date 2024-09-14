package br.edu.ifpb.domain.model.services;

import br.edu.ifpb.interfaces.service.*;

public class TourismGuideService extends ServiceDecorator {
    private final double TOURISM_GUIDE_COST = 30.0; 

    public TourismGuideService(ServiceDecorator service) {
        super(service);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + TOURISM_GUIDE_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Guia turístico";
    }
}
