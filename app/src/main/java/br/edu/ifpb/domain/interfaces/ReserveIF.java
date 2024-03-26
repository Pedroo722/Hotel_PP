package br.edu.ifpb.domain.interfaces;

import java.time.LocalDate;

import br.edu.ifpb.domain.wrappers.Id;

public interface ReserveIF { 
    public void checkIn(LocalDate date);

    public void checkOut(LocalDate date); 
       
    public void updateReserve(Id idReserva);

    public void cancelReserve(Id idReserva);
}
