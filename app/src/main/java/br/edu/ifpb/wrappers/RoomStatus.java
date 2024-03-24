package br.edu.ifpb.wrappers;

public class RoomStatus {
    private boolean status;

    public RoomStatus(boolean status) {
        this.status = status;
    }

    public void updateStatus(boolean newStatus) {
        status = newStatus;
    }
}