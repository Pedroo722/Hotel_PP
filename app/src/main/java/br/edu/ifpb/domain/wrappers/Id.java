package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

public class Id implements Serializable {
    private static int idCounter = 0;
    private final int id;

    public Id() {
        this.id = idCounter++;
    }

    public Id(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Id userId = (Id) obj;
        return id == userId.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}