package br.edu.ifpb.domain.services;

import br.edu.ifpb.interfaces.decorator.ServiceComponent;

public class BasicService implements ServiceComponent {
    private String description;
    private double cost;

    public BasicService(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
