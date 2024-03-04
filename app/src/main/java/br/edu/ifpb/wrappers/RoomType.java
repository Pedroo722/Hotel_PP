package br.edu.ifpb.wrappers;

public class RoomType {
    private final String type;

    public RoomType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("RoomType cannot be null or empty");
        }
        this.type = type;
    }
}
