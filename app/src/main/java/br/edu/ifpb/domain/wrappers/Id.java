package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

import br.edu.ifpb.exceptions.*;

public class Id implements Serializable {
    private static int idCounter = 0;
    private final int id;

    public Id() {
        this.id = idCounter++;
    }

    public Id(Integer id) {
        if (id == null) {
            throw new InvalidIdException();
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Id otherId = (Id) obj;
        return id == otherId.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}