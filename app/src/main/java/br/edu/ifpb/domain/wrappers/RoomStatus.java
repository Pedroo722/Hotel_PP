package br.edu.ifpb.domain.wrappers;

public enum RoomStatus {
    AVAILABLE("AVAILABLE"),
    OCCUPIED("OCCUPIED");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
