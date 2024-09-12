package br.edu.ifpb.interfaces.strategy;

import br.edu.ifpb.domain.model.Reserve;

public class RoomRateStrategy implements PriceStrategy {
    private static final double BASE_RATE = 100.0;
    @Override
    public double calculateBasePrice(Reserve reserve) {
        long days = java.time.Duration.between(reserve.getCheckIn(), reserve.getCheckOut()).toDays();
        return BASE_RATE * days;
    }
}
