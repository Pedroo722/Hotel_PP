package br.edu.ifpb.screens;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.db.DataBaseManager;

public class CadastrarHospedeWindow extends javax.swing.JFrame {

    private JLabel jLabelAdicionarHospede;
    private JLabel jLabelNome;
    private JLabel jLabelCpf;
    private JButton jButtonVoltar;
    private JButton jButtonCadastrar;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldCpf;
    private GuestController guestController;

    public CadastrarHospedeWindow() {
        initComponents();
        setLocationRelativeTo(null);
        DataBaseManager.initialize();
        guestController = new GuestController();
    }

    private void initComponents() {
        jLabelAdicionarHospede = new JLabel();
        jLabelNome = new JLabel();
        jLabelCpf = new JLabel();
        jButtonVoltar = new JButton();
        jButtonCadastrar = new JButton();
        jTextFieldNome = new JTextField();
        jTextFieldCpf = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelAdicionarHospede.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelAdicionarHospede.setText("Adicionar Hospede");

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNome.setText("Nome do Hospede:");

        jLabelCpf.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelCpf.setText("CPF:");

        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(evt -> jButtonVoltarActionPerformed(evt));

        jButtonCadastrar.setBackground(new java.awt.Color(102, 255, 102));
        jButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(evt -> jButtonCadastrarActionPerformed(evt));

        jTextFieldNome.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCpf.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(222, 222, 222)
                        .addComponent(jButtonCadastrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelAdicionarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNome)
                                .addComponent(jLabelCpf))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jTextFieldCpf))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelAdicionarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeString = jTextFieldNome.getText();
        String CpfString = jTextFieldCpf.getText();
    
        Name guestName = new Name(nomeString);
        CPF roomNumber = new CPF(CpfString);

        try {
            guestController.addGuest(guestName, roomNumber);
            javax.swing.JOptionPane.showMessageDialog(this, "Hóspede criado com sucesso!");    
        } catch (RuntimeException e) {

        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new MenuGuestWindow().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarHospedeWindow().setVisible(true);
        });
    }
}
