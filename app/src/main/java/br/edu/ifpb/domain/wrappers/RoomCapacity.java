package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

public class RoomCapacity implements Serializable {
    private Integer number;

    public RoomCapacity(Integer number) {
        if (number == null || number <= 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.number = number;
    }

    public Integer getValue() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
