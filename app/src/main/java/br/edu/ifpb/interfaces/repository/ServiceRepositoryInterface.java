package br.edu.ifpb.interfaces.repository;
import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface ServiceRepositoryInterface {
    public Service findServiceById(Id serviceId);
    public void addService(Service service);
    public void updateService(Service updatedService);
    public void removeService(Id id);
    public List<Service> getServices();
    // public List<Room> loadRoomsFromFile();
}
