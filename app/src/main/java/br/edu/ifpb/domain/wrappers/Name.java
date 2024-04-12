package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

import br.edu.ifpb.exceptions.InvalidNameException;

public class Name implements Serializable {
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

