package br.edu.ifpb.domain.wrappers;

public enum GuestStatus {
    HOSTED("HOSTED"),
    NOT_HOSTED("NOT_HOSTED");

    private final String status;

    GuestStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }

    public boolean isHosted() {
        if (status == "HOSTED") {
            return true;
        }
        return false;
    }
}