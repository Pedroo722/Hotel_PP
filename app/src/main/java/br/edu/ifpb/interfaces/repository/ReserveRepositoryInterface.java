package br.edu.ifpb.interfaces.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface ReserveRepositoryInterface {
    public Reserve findReserveById(Id id);
    public void addReserve(Reserve reserve);
    public void updateReserve(Reserve updatedReserve);
    public void removeReserve(Id id);
    public List<Reserve> getReserves();
}