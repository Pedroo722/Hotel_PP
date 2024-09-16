package br.edu.ifpb.interfaces.strategy;

import java.time.temporal.ChronoUnit;
import br.edu.ifpb.domain.model.Reserve;

// Padrão Comportamental: Strategy
public class RoomRateStrategy implements PriceStrategy {
    private static final double BASE_RATE = 100.0;

    @Override
    public double calculateBasePrice(Reserve reserve) {
        if (reserve.getCheckOut() == null) {
            return BASE_RATE * 1; 
        }

        long days = ChronoUnit.DAYS.between(reserve.getCheckIn(), reserve.getCheckOut());
        days = Math.max(days, 1);
        return BASE_RATE * days;
    }
}
