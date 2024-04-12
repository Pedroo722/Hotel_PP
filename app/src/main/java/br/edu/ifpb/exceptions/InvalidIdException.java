package br.edu.ifpb.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("Formato de Id inválido!");
    }
}
