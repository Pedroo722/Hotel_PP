package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.strategy.*;
import br.edu.ifpb.domain.model.services.*;
import br.edu.ifpb.interfaces.service.*;

public class Service {
    private Id serviceId;
    private ServiceDecorator services; // Padrão Estrutural: Decorator

    public Service() {
        this.serviceId = new Id();
        this.services = new BaseService(); 
    }

    public Id getServiceId() { return serviceId; }
    public ServiceDecorator getServices() { return this.services; }
    
    public void setServiceId(Id serviceId) { this.serviceId = serviceId; }
    public void addService(ServiceDecorator service) { this.services = service; }

    public double calculateTotalPrice(RoomRateStrategy roomRateStrategy, Reserve reserve) {
        double basePrice = roomRateStrategy.calculateBasePrice(reserve);
        double serviceCost = services.calculateCost();
        return basePrice + serviceCost;
    }

    @Override
    public String toString() {
        return "Service ID: " + serviceId + "\nServiços: " + services.getDescription();
    }
}
