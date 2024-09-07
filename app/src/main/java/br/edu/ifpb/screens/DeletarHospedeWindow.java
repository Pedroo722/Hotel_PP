// package br.edu.ifpb.screens;

// import javax.swing.JFrame;
// import javax.swing.SwingUtilities;

// import br.edu.ifpb.db.DataBaseManager;
// import br.edu.ifpb.presenter.controller.GuestController;

// public class DeletarHospedeWindow extends javax.swing.JPanel {
//     private javax.swing.JLabel jLabelTitulo;
//     private javax.swing.JLabel jLabelNumeroId;
//     private javax.swing.JTextField jTextFieldNumeroId;
//     private javax.swing.JButton jButtonDeletarHospede;
//     private javax.swing.JButton jButtonVoltar;
//     private GuestController guestController;

//     public DeletarHospedeWindow(String idHospede) {
//         initComponents();
//         DataBaseManager.initialize();
//         guestController = new GuestController();

//         jTextFieldNumeroId.setText(idHospede);
//     }

//     private void initComponents() {
//         jLabelTitulo = new javax.swing.JLabel();
//         jLabelNumeroId = new javax.swing.JLabel();
//         jTextFieldNumeroId = new javax.swing.JTextField();
//         jButtonDeletarHospede = new javax.swing.JButton();
//         jButtonVoltar = new javax.swing.JButton();

//         jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36));
//         jLabelTitulo.setText("Deletar Hospede");

//         jLabelNumeroId.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jLabelNumeroId.setText("ID do Hospede:");

//         jTextFieldNumeroId.setFont(new java.awt.Font("Segoe UI", 0, 18));

//         jButtonDeletarHospede.setFont(new java.awt.Font("Segoe UI", 0, 18));
//         jButtonDeletarHospede.setText("Deletar Hospede");
//         jButtonDeletarHospede.setBackground(new java.awt.Color(153, 255, 51));
//         jButtonDeletarHospede.setForeground(new java.awt.Color(51, 51, 51));

//         jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jButtonVoltar.setText("Voltar");
//         jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
//         jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
//         jButtonVoltar.addActionListener(evt -> jButtonVoltarActionPerformed(evt));

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//         this.setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                 .addContainerGap(160, Short.MAX_VALUE)
//                 .addComponent(jLabelTitulo)
//                 .addGap(160, 160, 160))
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(50, 50, 50)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(layout.createSequentialGroup()
//                         .addComponent(jLabelNumeroId)
//                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                         .addComponent(jTextFieldNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
//                     .addGroup(layout.createSequentialGroup()
//                         .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
//                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
//                         .addComponent(jButtonDeletarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                 .addGap(50, 50, 50))
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(30, 30, 30)
//                 .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addGap(50, 50, 50)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jLabelNumeroId)
//                     .addComponent(jTextFieldNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addGap(50, 50, 50)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jButtonDeletarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
//                     .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addContainerGap(100, Short.MAX_VALUE))
//         );
//     }

//     private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
//         dispose(); 
//         new MenuGuestWindow().setVisible(true);    }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Deletar Hospede");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setSize(600, 350);
//             frame.setContentPane(new DeletarHospedeWindow("1"));
//             frame.setVisible(true);
//         });
//     }
// }
