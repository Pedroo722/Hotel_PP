package br.edu.ifpb.screens;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JButton jButtonRoom = new JButton();
        JButton jButtonGuest = new JButton();
        JButton jButtonReservations = new JButton(); // Novo botão para Reservas
        JLabel jLabelMenu = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonRoom.setBackground(new java.awt.Color(153, 153, 255));
        jButtonRoom.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonRoom.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRoom.setText("Quartos");
        jButtonRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoomActionPerformed(evt);
            }
        });

        jButtonGuest.setBackground(new java.awt.Color(153, 153, 255));
        jButtonGuest.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonGuest.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuest.setText("Hóspedes");
        jButtonGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuestActionPerformed(evt);
            }
        });

        jButtonReservations.setBackground(new java.awt.Color(153, 153, 255));
        jButtonReservations.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButtonReservations.setForeground(new java.awt.Color(0, 0, 0));
        jButtonReservations.setText("Reservas");
        jButtonReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservationsActionPerformed(evt);
            }
        });

        jLabelMenu.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabelMenu.setText("Menu");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonReservations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenu)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelMenu)
                .addGap(39, 39, 39)
                .addComponent(jButtonReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonRoomActionPerformed(java.awt.event.ActionEvent evt) {
        // screenManager.showRoomWindow();
    }
    
    private void jButtonGuestActionPerformed(java.awt.event.ActionEvent bvt) {
        // screenManager.showGuestWindow();
    }

    private void jButtonReservationsActionPerformed(java.awt.event.ActionEvent bvt) {
        // screenManager.showReservationsWindow();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
