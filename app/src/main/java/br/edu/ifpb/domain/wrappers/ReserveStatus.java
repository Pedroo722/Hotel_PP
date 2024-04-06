package br.edu.ifpb.domain.wrappers;

public enum ReserveStatus {
    ACTIVE(true),
    CANCELED(false);

    private final boolean status;

    ReserveStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
