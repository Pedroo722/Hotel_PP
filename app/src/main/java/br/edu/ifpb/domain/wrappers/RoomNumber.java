package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

public class RoomNumber implements Serializable {
    private final Integer number;

    public RoomNumber(Integer number) {
        if (number == null && number <= 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
