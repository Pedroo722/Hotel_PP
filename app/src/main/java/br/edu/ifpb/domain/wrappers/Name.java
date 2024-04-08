package br.edu.ifpb.domain.wrappers;

public class Name {
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

