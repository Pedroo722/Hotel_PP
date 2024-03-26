package br.edu.ifpb.domain.wrappers;

public class Id {
    private static int idCounter = 0;
    private final int id;

    public Id() {
        this.id = idCounter++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Id userId = (Id) obj;
        return id == userId.id;
    }
}