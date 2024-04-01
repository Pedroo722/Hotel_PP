package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface ReserveRepositoryInterface {
    public void save(Reserve reserve);
    public Reserve findReserveById(Id id);
    public void updateReserve(Reserve reserve);
}