package br.edu.ifpb.domain.wrappers;

import java.io.Serializable;

import br.edu.ifpb.exceptions.*;

public class CPF implements Serializable {
    private final String cpf;

    public CPF(String cpf) {
        if (cpf == null || cpf.isEmpty() || cpf.length() < 11) {
            throw new InvalidCPFException();
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        // Formatando o CPF para exibição (XXX.XXX.XXX-XX)
        return cpf.replaceAll("^(\\d{3})(\\d{3})(\\d{3})(\\d{2})$", "$1.$2.$3-$4");
    }
}