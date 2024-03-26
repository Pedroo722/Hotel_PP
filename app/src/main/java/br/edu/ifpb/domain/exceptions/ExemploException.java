package br.edu.ifpb.domain.exceptions;

public class ExemploException extends RuntimeException {
    public ExemploException() {
        super("Dados em formato inválido!");
    }
}