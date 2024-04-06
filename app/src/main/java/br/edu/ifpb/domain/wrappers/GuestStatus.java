package br.edu.ifpb.domain.wrappers;

public enum GuestStatus {
    HOSTED(true),
    NOT_HOSTED(false);

    private final boolean status;

    GuestStatus(boolean status) {
        this.status = status;
    }

    public boolean isHosted() {
        return status;
    }
}