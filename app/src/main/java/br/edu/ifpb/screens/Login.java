
package br.edu.ifpb.screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import br.edu.ifpb.exceptions.LoginErradoException;


public class Login extends JFrame implements ActionListener{
    
    JLabel usuarioJLabel, senhaJlabel;
    JTextField usuarioTextField;
    JPasswordField senhaTextField;
    JButton butaoLogin, butaoVoltar;

    public Login(){
        setTitle("Login");

        setLayout(null);
        
        usuarioJLabel = new JLabel("Usuário:");
        usuarioJLabel.setBounds(40,20,100,30);
        add(usuarioJLabel);
        
        senhaJlabel = new JLabel("Senha:");
        senhaJlabel.setBounds(40,70,100,30);
        add(senhaJlabel);
 
        usuarioTextField = new JTextField();
        usuarioTextField.setBounds(150,20,150,30);
        add(usuarioTextField);

        senhaTextField = new JPasswordField();
        senhaTextField.setBounds(150,70,150,30);
        add(senhaTextField);


        butaoLogin = new JButton("Login");
        butaoLogin.setBounds(40,140,120,30);
        butaoLogin.setFont(new Font("serif",Font.BOLD,15));
        butaoLogin.addActionListener(this);
        butaoLogin.setBackground(Color.BLACK);
        butaoLogin.setForeground(Color.WHITE);
        add(butaoLogin);

        butaoVoltar = new JButton("Cancel");
        butaoVoltar.setBounds(180,140,120,30);
        butaoVoltar.setFont(new Font("serif",Font.BOLD,15));
        butaoVoltar.setBackground(Color.BLACK);
        butaoVoltar.setForeground(Color.WHITE);
        add(butaoVoltar);

        butaoVoltar.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(400,300);
        setLocation(600,350);

    }

    public void actionPerformed(ActionEvent ae){
        /* 

        try{
           // Lógica para fazer o login
        } catch(LoginErradoException e){
            JOptionPane.showMessageDialog(this, "Operação falha. Os dados do login estão incorretos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        */
    }
    public static void main(String[] arg){
        new Login();
    }
}