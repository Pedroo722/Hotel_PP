package br.edu.ifpb.screens;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    public MainWindow() {
        setTitle("Sistema de Gerenciamento de Hotel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 300);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setLayout(null); 

        JLabel titulo = new JLabel("Sistema de Gerenciamento de Hotel");
        titulo.setBounds(250, 20, 300, 30); 

        JButton reservasBtn = new JButton("Gerenciar Reservas");
        JButton hospedesBtn = new JButton("Gerenciar Hóspedes");
        JButton quartosBtn = new JButton("Gerenciar Quartos");

        reservasBtn.setBounds(300, 70, 200, 30);
        hospedesBtn.setBounds(300, 120, 200, 30); 
        quartosBtn.setBounds(300, 170, 200, 30); 

        reservasBtn.addActionListener(this);
        hospedesBtn.addActionListener(this);
        quartosBtn.addActionListener(this);

        panel.add(titulo);
        panel.add(reservasBtn);
        panel.add(hospedesBtn);
        panel.add(quartosBtn);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Gerenciar Reservas")) {
            // ir para reservas
        } else if (e.getActionCommand().equals("Gerenciar Hóspedes")) {
            // ir para hóspedes
        } else if (e.getActionCommand().equals("Gerenciar Quartos")) {
            // ir para quartos
        }
    }
}
