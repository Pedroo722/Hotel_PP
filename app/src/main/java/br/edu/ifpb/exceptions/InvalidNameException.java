package br.edu.ifpb.exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException() {
        super("Nome inválido!");
    }
}
