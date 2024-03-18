package br.edu.ifpb.interfaces;

import java.util.List;

import br.edu.ifpb.model.Reserve;
import br.edu.ifpb.wrappers.Id;

public interface ReserveIF {    
    public void updateReserve(Id idReserva);

    public void cancelReserve(Id idReserva);
    
}
