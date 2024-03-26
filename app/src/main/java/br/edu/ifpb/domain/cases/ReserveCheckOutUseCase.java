package br.edu.ifpb.domain.cases;

import java.time.LocalDate;

import br.edu.ifpb.domain.model.Reserve;

public class ReserveCheckOutUseCase {
    public void checkOut(Reserve reserve, LocalDate checkOutDate) {
        if (checkOutDate == null || checkOutDate.isBefore(reserve.getCheckIn())) {
            return;
        }        
        reserve.setCheckOut(checkOutDate);
    }    
}
