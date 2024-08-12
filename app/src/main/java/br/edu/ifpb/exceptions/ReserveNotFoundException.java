package br.edu.ifpb.exceptions;

public class ReserveNotFoundException extends RuntimeException {
    public ReserveNotFoundException() {
        super("Reserva não encontrada!");
    }
}