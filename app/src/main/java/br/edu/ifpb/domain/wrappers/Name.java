package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

public class Name implements Serializable {
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

