package br.edu.ifpb.exceptions;

public class ReserveNotFoundException extends RuntimeException {
    public ReserveNotFoundException() {
        super("Dados em formato inválido!");
    }
}