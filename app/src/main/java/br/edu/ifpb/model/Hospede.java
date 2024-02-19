package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.HospedeIF;

public class Hospede implements HospedeIF {
    String nome;
    int idade;
    String genero;
    String telefone;
    String email;

    public Hospede(String nome, int idade, String genero, String telefone, String email) {
        nome = this.nome;
        idade = this.idade;
        genero = this.genero;
        telefone = this.telefone;
        email = this.email;
    }

    
}
