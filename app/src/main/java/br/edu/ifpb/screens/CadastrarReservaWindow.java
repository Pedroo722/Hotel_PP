// package br.edu.ifpb.screens;

// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.JTextField;

// import br.edu.ifpb.db.DataBaseManager;
// import br.edu.ifpb.domain.wrappers.*;
// import br.edu.ifpb.presenter.controller.ReserveController;

// public class CadastrarReservaWindow extends javax.swing.JFrame {

//     private JLabel jLabelAdicionarReserva;
//     private JLabel jLabelID;
//     private JLabel jLabelNumero;
//     private JButton jButtonVoltar;
//     private JButton jButtonCadastrar;
//     private JTextField jTextFieldID;
//     private JTextField jTextFieldNumero;
//     private ReserveController reserveController;

//     public CadastrarReservaWindow() {
//         initComponents();
//         setLocationRelativeTo(null);
//         DataBaseManager.initialize();
//         reserveController = new ReserveController();

//     }

//     private void initComponents() {
//         jLabelAdicionarReserva = new JLabel();
//         jLabelID = new JLabel();
//         jLabelNumero = new JLabel();
//         jButtonVoltar = new JButton();
//         jButtonCadastrar = new JButton();
//         jTextFieldID = new JTextField();
//         jTextFieldNumero = new JTextField();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//         setMaximumSize(new java.awt.Dimension(869, 570));
//         setMinimumSize(new java.awt.Dimension(869, 570));
//         setPreferredSize(new java.awt.Dimension(869, 570));
//         setResizable(false);

//         jLabelAdicionarReserva.setFont(new java.awt.Font("Segoe UI", 1, 36));
//         jLabelAdicionarReserva.setText("Adicionar Reserva");

//         jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jLabelID.setText("ID do Hóspede:");

//         jLabelNumero.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jLabelNumero.setText("Número do Quarto:");

//         jButtonVoltar.setBackground(new java.awt.Color(204, 204, 255));
//         jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jButtonVoltar.setForeground(new java.awt.Color(0, 0, 0));
//         jButtonVoltar.setText("Voltar");
//         jButtonVoltar.addActionListener(evt -> jButtonVoltarActionPerformed(evt));

//         jButtonCadastrar.setBackground(new java.awt.Color(102, 255, 102));
//         jButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 24));
//         jButtonCadastrar.setForeground(new java.awt.Color(0, 0, 0));
//         jButtonCadastrar.setText("Cadastrar");
//         jButtonCadastrar.addActionListener(evt -> jButtonCadastrarActionPerformed(evt));

//         jTextFieldID.setBackground(new java.awt.Color(255, 255, 255));
//         jTextFieldNumero.setBackground(new java.awt.Color(255, 255, 255));

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(179, 179, 179)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(layout.createSequentialGroup()
//                         .addComponent(jButtonVoltar)
//                         .addGap(222, 222, 222)
//                         .addComponent(jButtonCadastrar))
//                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                         .addComponent(jLabelAdicionarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
//                         .addGroup(layout.createSequentialGroup()
//                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                 .addComponent(jLabelID)
//                                 .addComponent(jLabelNumero))
//                             .addGap(72, 72, 72)
//                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                 .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
//                                 .addComponent(jTextFieldNumero))))))
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(38, 38, 38)
//                 .addComponent(jLabelAdicionarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                 .addGap(83, 83, 83)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jLabelID)
//                     .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addGap(22, 22, 22)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jLabelNumero)
//                     .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
//                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                     .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addGap(57, 57, 57))
//         );

//         pack();
//     }

//     private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
//         String idString = jTextFieldID.getText();
//         String numeroString = jTextFieldNumero.getText();
    
//         Id guestId = new Id(idString);
//         RoomNumber roomNumber = new RoomNumber(numeroString);
//         Id serviceId = new Id(serviceIdString);

//         try {
//             reserveController.addReserve(guestId, roomNumber, serviceId);
//             javax.swing.JOptionPane.showMessageDialog(this, "Hóspede criado com sucesso!");    
//         } catch (RuntimeException e) {

//         }
//     }

//     private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
//         dispose(); 
//         new MenuReserveWindow().setVisible(true);
//     }

//     public static void main(String args[]) {
//         java.awt.EventQueue.invokeLater(() -> {
//             new CadastrarReservaWindow().setVisible(true);
//         });
//     }
// }
