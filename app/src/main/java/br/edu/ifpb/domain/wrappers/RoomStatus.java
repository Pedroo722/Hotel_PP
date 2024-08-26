package br.edu.ifpb.domain.wrappers;

public enum RoomStatus {
    AVAILABLE(1),
    OCCUPIED(0);

    private final int status;

    RoomStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return status;
    }
}
