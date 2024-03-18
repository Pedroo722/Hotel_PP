package br.edu.ifpb.model;

import java.time.LocalDate;
import java.util.List;
import br.edu.ifpb.interfaces.ReserveIF;
import br.edu.ifpb.wrappers.*;

public class Reserve implements ReserveIF {
    private final Id reserveId;
    private LocalDate date;
    private final Id guestId;
    

    public Reserve(Id reserveId, LocalDate date, Id guestId) {
        this.reserveId = new Id();
        this.date = date;
        this.guestId = guestId;
    }
    
    public boolean isSameReserve(Id reserveId) {
        return this.reserveId.equals(reserveId);
    }


    public void updateReserve(Id reserveId) {

    }

    public void cancelReserve(Id reserveId) {

    }
}
