package br.edu.ifpb.exceptions;

public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException() {
        super("Hóspede não encontrado!");
    }   
}
