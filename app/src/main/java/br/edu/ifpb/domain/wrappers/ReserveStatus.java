package br.edu.ifpb.domain.wrappers;

public enum ReserveStatus {
    ACTIVE(true),
    FINALIZED(false);

    private final boolean status;

    ReserveStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        if (status == true) {
            return "ACTIVE";
        } else {
            return "FINALIZED";
        }
    }

    public boolean getStatus() {
        return status;
    }
}
