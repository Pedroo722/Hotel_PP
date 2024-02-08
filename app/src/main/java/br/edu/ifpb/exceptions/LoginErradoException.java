package br.edu.ifpb.exceptions;

public class LoginErradoException extends RuntimeException {
    public LoginErradoException() {
        super("Login incorreto!");
    }
}