package br.edu.ifpb.exceptions;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException() {
        super("Serviços não encontrados!");
    }   
}
