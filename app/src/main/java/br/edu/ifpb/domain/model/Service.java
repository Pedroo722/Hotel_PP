package br.edu.ifpb.domain.model;

import java.util.*;

import br.edu.ifpb.interfaces.strategy.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.decorator.*;

public class Service {
    private Id serviceId;
    private List<ServiceComponent> listOfServices; 

    public Service() {
        this.serviceId = new Id();
        this.listOfServices = new ArrayList<>();
    }

    public Service(Id serviceId) {
        this.serviceId = serviceId;
        this.listOfServices = new ArrayList<>();
    }

    public Id getServiceId() { return serviceId; }
    public void setServiceId(Id serviceId) { this.serviceId = serviceId; }
    public List<ServiceComponent> getListOfServices() { return listOfServices; }
    public void setListOfServices(List<ServiceComponent> listOfServices) { this.listOfServices = listOfServices; }

    public void addService(ServiceComponent service) {
        listOfServices.add(service);
    }

    public double calculateTotalPrice(RoomRateStrategy roomRateStrategy, Reserve reserve) {
        double basePrice = roomRateStrategy.calculateBasePrice(reserve);
        double serviceCost = listOfServices.stream().mapToDouble(ServiceComponent::getCost).sum();
        return basePrice + serviceCost;
    }
}