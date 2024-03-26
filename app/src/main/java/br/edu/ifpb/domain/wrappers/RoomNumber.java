package br.edu.ifpb.domain.wrappers;

public class RoomNumber {
    private final Integer number;

    public RoomNumber(Integer number) {
        if (number != null && number > 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.number = number;
    }
}
