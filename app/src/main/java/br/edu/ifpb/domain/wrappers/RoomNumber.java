package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

import br.edu.ifpb.exceptions.*;

public class RoomNumber implements Serializable {
    private final Integer number;

    public RoomNumber(Integer number) {
        if (number == null || number <= 0) {
            throw new InvalidRoomNumberException();
        }
        this.number = number;
    }

    public RoomNumber(String roomNumber) {
        this.number = Integer.parseInt(roomNumber);
    }

    public Integer getValue() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RoomNumber otherRoomNumber = (RoomNumber) obj;
        return number.equals(otherRoomNumber.number);
    }
}
