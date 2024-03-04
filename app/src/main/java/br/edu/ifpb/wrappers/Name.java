package br.edu.ifpb.wrappers;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
}

