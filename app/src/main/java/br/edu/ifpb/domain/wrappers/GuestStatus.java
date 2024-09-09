package br.edu.ifpb.domain.wrappers;

public enum GuestStatus {
    HOSTED(true),
    NOT_HOSTED(false);

    private final boolean status;

    GuestStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        if (status == true) {
            return "HOSTED";
        } else {
            return "NOT_HOSTED";
        }
    }

    public boolean getValue() {
        return status;
    }
}