package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface ReserveRepositoryInterface {
    public void saveReserves(Reserve reserve);
    public Reserve findReserveById(Id id);
}