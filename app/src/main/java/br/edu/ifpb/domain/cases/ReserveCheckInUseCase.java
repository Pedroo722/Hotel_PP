package br.edu.ifpb.domain.cases;

import java.time.LocalDate;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.ReserveStatus;

public class ReserveCheckInUseCase {
    public void checkIn(Reserve reserve, LocalDate checkInDate) {
        if (checkInDate == null || checkInDate.isBefore(LocalDate.now())) {
            return;
        }
        reserve.setCheckIn(checkInDate);
        reserve.setStatus(new ReserveStatus(true));
    }
}
