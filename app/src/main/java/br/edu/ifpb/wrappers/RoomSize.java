package br.edu.ifpb.wrappers;

public class RoomSize {
    private final String size;

    public RoomSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("RoomSize cannot be null or empty");
        }
        this.size = size;
    }
}
