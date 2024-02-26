package br.edu.ifpb.screens;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewClient extends JFrame{
	JTextField textFieldNome, textFieldIdade, textFieldTelefone, textFieldEmail;
    JComboBox generoOpcoes;

    public NewClient(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Cadastrar Cliente");
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);
        
        JLabel detalhesLabel = new JLabel("Detalhes do Cliente");
        detalhesLabel.setForeground(Color.BLUE);
        detalhesLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        detalhesLabel.setBounds(450, 24, 442, 35);
        add(detalhesLabel);

        // Nome
        
        JLabel nome = new JLabel("Nome:");
        nome.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nome.setBounds(60, 30, 150, 27);
        add(nome);
        
        textFieldNome = new JTextField();
        textFieldNome.setBounds(200, 30, 150, 27);
        add(textFieldNome);

        // Idade
        
        JLabel idade = new JLabel("Idade:");
        idade.setFont(new Font("Tahoma", Font.PLAIN, 17));
        idade.setBounds(60, 80, 150, 27);
        add(idade);
        
        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(200, 80, 150, 27);
        add(textFieldIdade);

        // Gênero
        
        JLabel genero = new JLabel("Gênero:");
        genero.setFont(new Font("Tahoma", Font.PLAIN, 17));
        genero.setBounds(60, 120, 150, 27);
        add(genero);
    
        String opcoes[] = {"Masculino","Feminino", "Outro"};
        generoOpcoes = new JComboBox(opcoes);
        generoOpcoes.setBackground(Color.WHITE);
        generoOpcoes.setBounds(200, 120, 150, 27);
        add(generoOpcoes);

        // Telefone

        JLabel telefone = new JLabel("Telefone:");
        telefone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        telefone.setBounds(60, 170, 170, 27);
        add(telefone);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(200, 170, 150, 27);
        add(textFieldTelefone);

        // Email
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 220, 150, 27);
        add(email);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 220, 150, 27);
        add(textFieldEmail);

        // Butão de Salvar Cliente

        JButton SaveButton = new JButton("Salvar");
        SaveButton.setBounds(200, 300, 150, 30);
        SaveButton.setBackground(Color.BLACK);
        SaveButton.setForeground(Color.WHITE);
        add(SaveButton);
        
        SaveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                // ação para salvar o Cliente
            }
        });
        
        setSize(900,600);
        setVisible(true);
        setLocation(530,200);   
	}
        
    public static void main(String[] args){
        new NewClient();
    }   
}