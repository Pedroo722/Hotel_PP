package br.edu.ifpb.wrappers;

public class CPF {
    private final String cpf;

    public CPF(String cpf) {
        if (cpf == null || cpf.isEmpty() || cpf.length() < 11) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        this.cpf = cpf;
    }
}