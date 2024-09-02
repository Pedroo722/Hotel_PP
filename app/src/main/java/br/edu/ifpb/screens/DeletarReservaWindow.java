package br.edu.ifpb.screens;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DeletarReservaWindow extends javax.swing.JPanel {

    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelNumeroId;
    private javax.swing.JTextField jTextFieldNumeroId;
    private javax.swing.JButton jButtonDeletarReserva;
    private javax.swing.JButton jButtonVoltar;

    public DeletarReservaWindow() {
        initComponents();
    }

    private void initComponents() {
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNumeroId = new javax.swing.JLabel();
        jTextFieldNumeroId = new javax.swing.JTextField();
        jButtonDeletarReserva = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelTitulo.setText("Deletar Reserva");

        jLabelNumeroId.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNumeroId.setText("ID da Reserva:");

        jTextFieldNumeroId.setFont(new java.awt.Font("Segoe UI", 0, 18));

        jButtonDeletarReserva.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonDeletarReserva.setText("Deletar Reserva");
        jButtonDeletarReserva.setBackground(new java.awt.Color(153, 255, 51));
        jButtonDeletarReserva.setForeground(new java.awt.Color(51, 51, 51));

        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltar.addActionListener(evt -> jButtonVoltarActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumeroId)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDeletarReserva)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroId)
                    .addComponent(jTextFieldNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeletarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar))
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Deletar Reserva");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(530, 380);
            frame.setContentPane(new DeletarReservaWindow());
            frame.setVisible(true);
        });
    }
}