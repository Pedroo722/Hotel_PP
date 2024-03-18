package br.edu.ifpb.wrappers;

public class GuestStatus {
    private boolean status;

    public GuestStatus(boolean status) {
        this.status = status;
    }

    public boolean isHosted() {
        return status;
    }

    public void updateStatus(boolean newStatus) {
        status = newStatus;
    }
}
