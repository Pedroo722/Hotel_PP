package br.edu.ifpb.domain.wrappers;

public enum ReserveStatus {
    ACTIVE(true),
    CANCELED(false);

    private final boolean status;

    ReserveStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        if (status == true) {
            return "ACTIVE";
        } else {
            return "CANCELLED";
        }
    }

    public boolean getStatus() {
        return status;
    }
}
