package br.edu.ifpb.interfaces.repository;

import java.util.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface ServiceRepositoryInterface {
    public Service findServiceById(Id id);
    public void addService(Service service, boolean hasBreakfast, boolean hasPetCare, boolean hasSpa, boolean hasTourism);
    public void updateService(Service updatedService);
    public void removeService(Id id);
    public List<Service> getServices();
}
