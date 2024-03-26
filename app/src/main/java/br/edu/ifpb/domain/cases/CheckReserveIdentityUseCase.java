package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.model.Reserve;

public class CheckReserveIdentityUseCase {
    public static boolean isSameReserve(Reserve reserve, Id reserveId) {
        return reserve.getReserveId().equals(reserveId);
    }
}