package br.edu.ifpb.presenter.controller;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.service.*;
import br.edu.ifpb.data.ServiceRepository;

import java.util.List;

public class ServiceController {
    private ServiceRepository repository;

    public ServiceController() {
        this.repository = ServiceRepository.getInstance();
    }

    public void addService(Service service) {
        ServiceDecorator services = service.getServices();
        String description = services.getDescription();

        boolean hasBreakfast = description.contains("Café");
        boolean hasPetCare = description.contains("Pet");
        boolean hasSpa = description.contains("Spa");
        boolean hasTourism = description.contains("Guia");

        if (!hasBreakfast && !hasPetCare && !hasSpa && !hasTourism) {
            System.out.println("Nenhum serviço adicional foi selecionado.");
            return;
        }

        repository.addService(service, hasBreakfast, hasPetCare, hasSpa, hasTourism);
    }

    public void listServices() {
        List<Service> services = repository.getServices();

        if (services.isEmpty()) {
            System.out.println("\nA lista de serviços está vazia!\n");
            return;
        }

        int count = 1;
        System.out.println("\n== Lista de Serviços ==");
        for (Service service : services) {
            System.out.println("Serviço: " + count);
            System.out.println(service.getServices().getDescription());
            System.out.println();
            count++;
        }
    }

    public void editService(Id id, Service service) {
        Service existingService = repository.findServiceById(id);

        existingService.addService(service.getServices());

        repository.updateService(existingService);
    }

    public void removeService(Id id) {
        repository.removeService(id);
    }

    public Service getServiceById(Id serviceId) {
        return repository.findServiceById(serviceId);
    }

    public List<Service> getListServices() {
        return repository.getServices();
    }

    public void handleFinish() {
        repository.saveServicesToDB();
    }
}
