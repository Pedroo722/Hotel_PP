package br.edu.ifpb.domain.wrappers;

public class RoomCapacity {
    private Integer number;

    public RoomCapacity(Integer number) {
        if (number != null && number > 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.number = number;
    }
}
