package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.ServiceComponent;

public class TourismGuideService extends ServiceDecorator {
    private static final double TOURISM_GUIDE_COST = 20.0;

    public TourismGuideService(ServiceComponent decoratedService) {
        super(decoratedService);
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription() + "Guia Turístico";
    }

    @Override
    public double getCost() {
        return decoratedService.getCost() + TOURISM_GUIDE_COST;
    }
}
