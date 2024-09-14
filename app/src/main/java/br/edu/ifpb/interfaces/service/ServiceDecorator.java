package br.edu.ifpb.interfaces.service;

public abstract class ServiceDecorator {
    protected ServiceDecorator service;

    public ServiceDecorator(ServiceDecorator service) {
        this.service = service;
    }

    public double calculateCost() {
        if (service != null) {
            return service.calculateCost();
        }
        return 0;
    }

    public String getDescription() {
        if (service != null) {
            return service.getDescription();
        }
        return "Serviços:";
    }
}
