package br.edu.ifpb.domain.wrappers;

public enum RoomStatus {
    AVAILABLE(true),
    OCCUPIED(false);

    private final boolean status;

    RoomStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
