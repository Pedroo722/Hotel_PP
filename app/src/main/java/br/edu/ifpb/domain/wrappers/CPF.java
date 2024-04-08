package br.edu.ifpb.domain.wrappers;

public class CPF {
    private final String cpf;

    public CPF(String cpf) {
        if (cpf == null || cpf.isEmpty() || cpf.length() < 11) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        // Formatando o CPF para exibição (XXX.XXX.XXX-XX)
        return cpf.replaceAll("^(\\d{3})(\\d{3})(\\d{3})(\\d{2})$", "$1.$2.$3-$4");
    }
}