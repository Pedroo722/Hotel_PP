package br.edu.ifpb.domain.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.ReserveUseCase.CheckReserveIdentityUseCase;
import br.edu.ifpb.domain.wrappers.Id;

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
            if (CheckReserveIdentityUseCase.isSameReserve(reserve, reserveId)) {
                return reserve;
            }
        }
        return null;
    }
}