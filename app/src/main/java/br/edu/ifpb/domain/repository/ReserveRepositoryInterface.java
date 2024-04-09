package br.edu.ifpb.domain.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface ReserveRepositoryInterface {
    public Reserve findReserveById(Id id);
    public List<Reserve> loadReservesFromFile();
}