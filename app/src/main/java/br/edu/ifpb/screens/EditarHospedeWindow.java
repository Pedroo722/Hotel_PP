package br.edu.ifpb.screens;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarHospedeWindow extends javax.swing.JFrame {
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelEditarProduto;
    private javax.swing.JLabel jLabelIdProduto;
    private javax.swing.JLabel jLabelNovoNome;
    private javax.swing.JLabel jLabelNovoPreco;
    private javax.swing.JTextField jTextFieldIdProduto;
    private javax.swing.JTextField jTextFieldNovoNome;
    private javax.swing.JTextField jTextFieldNovoPreco;
    
    public EditarHospedeWindow() {
        initComponents();
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {

            }
        });
    }

    private void initComponents() {
        jLabelEditarProduto = new JLabel();
        jLabelNovoNome = new JLabel();
        jButtonVoltar = new JButton();
        jButtonEditar = new JButton();
        jLabelNovoPreco = new JLabel();
        jTextFieldNovoNome = new JTextField();
        jTextFieldNovoPreco = new JTextField();
        jLabelIdProduto = new JLabel();
        jTextFieldIdProduto = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(869, 570));
        setMinimumSize(new Dimension(869, 570));
        setPreferredSize(new Dimension(869, 570));
        setResizable(false);

        jLabelEditarProduto.setFont(new Font("Segoe UI", Font.BOLD, 36));
        jLabelEditarProduto.setText("Editar Hospede");

        jLabelNovoNome.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jLabelNovoNome.setText("Novo Nome:");

        jButtonVoltar.setBackground(new Color(204, 204, 255));
        jButtonVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jButtonVoltar.setForeground(Color.BLACK);
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButtonVoltarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new Color(255, 153, 0));
        jButtonEditar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jButtonEditar.setForeground(Color.BLACK);
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jLabelNovoPreco.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jLabelNovoPreco.setText("Novo CPF:");

        jTextFieldNovoNome.setBackground(Color.WHITE);
        jTextFieldNovoPreco.setBackground(Color.WHITE);

        jLabelIdProduto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jLabelIdProduto.setText("ID do Hospede editado:");

        jTextFieldIdProduto.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jLabelNovoNome)
                    .addComponent(jLabelIdProduto))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNovoPreco)
                    .addComponent(jTextFieldNovoNome)
                    .addComponent(jTextFieldIdProduto, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addGap(216, 216, 216)
                        .addComponent(jButtonEditar)
                        .addGap(126, 126, 126))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelEditarProduto)
                        .addGap(218, 218, 218))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelEditarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIdProduto)
                    .addComponent(jTextFieldIdProduto, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNovoNome)
                    .addComponent(jTextFieldNovoNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNovoPreco)
                    .addComponent(jTextFieldNovoPreco, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonEditar))
                .addGap(37, 37, 37))
        );

        pack();
    }

    private void jButtonEditarActionPerformed(ActionEvent evt) {

    }

    private void JButtonVoltarActionPerformed(ActionEvent evt) {

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarHospedeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new EditarHospedeWindow().setVisible(true));
    }
}
