package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.wrappers.Id;

public class ReserveCollections {
    private List<Reserve> reserveList;

    public ReserveCollections() {
        this.reserveList = new ArrayList<>();
    }

    public List<Reserve> consultReserves() {
        return reserveList;
    }

    public Reserve searchReserve(Id reserveId) {
        for (Reserve reserve : reserveList) {
            if (reserve.isSameReserve(reserveId)) {
                return reserve;
            }
        }
        return null;
    }
}