// package br.edu.ifpb.screens;

// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.JTextField;
// import javax.swing.GroupLayout;
// import javax.swing.WindowConstants;

// import br.edu.ifpb.db.DataBaseManager;
// import br.edu.ifpb.domain.wrappers.*;
// import br.edu.ifpb.presenter.controller.ReserveController;

// import java.awt.Dimension;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class EditarReservaWindow extends javax.swing.JFrame {
//     private javax.swing.JButton jButtonEditar;
//     private javax.swing.JButton jButtonVoltar;
//     private javax.swing.JLabel jLabelEditarReserva;
//     private javax.swing.JLabel jLabelIdReserva;
//     private javax.swing.JLabel jLabelNovoNome;
//     private javax.swing.JLabel jLabelNovoNumero;
//     private javax.swing.JTextField jTextFieldIdReserva;
//     private javax.swing.JTextField jTextFieldNovoNome;
//     private javax.swing.JTextField jTextFieldNovoQuarto;
//     private ReserveController reserveController;
    
//     public EditarReservaWindow(String idReserva, String idHospede, String numeroQuarto) {
//         initComponents();
//         setLocationRelativeTo(null);
//         DataBaseManager.initialize();
//         reserveController = new ReserveController();

//         jTextFieldIdReserva.setText(idReserva);
//         jTextFieldNovoNome.setText(idHospede);
//         jTextFieldNovoQuarto.setText(numeroQuarto);

//         jTextFieldIdReserva.setEditable(false);

//         addWindowListener(new java.awt.event.WindowAdapter() {
//             @Override
//             public void windowClosing(java.awt.event.WindowEvent evt) {

//             }
//         });
//     }

//     private void initComponents() {
//         jLabelEditarReserva = new JLabel();
//         jLabelNovoNome = new JLabel();
//         jButtonVoltar = new JButton();
//         jButtonEditar = new JButton();
//         jLabelNovoNumero = new JLabel();
//         jTextFieldNovoNome = new JTextField();
//         jTextFieldNovoQuarto = new JTextField();
//         jLabelIdReserva = new JLabel();
//         jTextFieldIdReserva = new JTextField();

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setMaximumSize(new Dimension(869, 570));
//         setMinimumSize(new Dimension(869, 570));
//         setPreferredSize(new Dimension(869, 570));
//         setResizable(false);

//         jLabelEditarReserva.setFont(new Font("Segoe UI", Font.BOLD, 36));
//         jLabelEditarReserva.setText("Editar Hospede");

//         jLabelNovoNome.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelNovoNome.setText("ID do novo hóspede:");

//         jButtonVoltar.setBackground(new Color(204, 204, 255));
//         jButtonVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jButtonVoltar.setForeground(Color.BLACK);
//         jButtonVoltar.setText("Voltar");
//         jButtonVoltar.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent evt) {
//                 JButtonVoltarActionPerformed(evt);
//             }
//         });

//         jButtonEditar.setBackground(new Color(255, 153, 0));
//         jButtonEditar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jButtonEditar.setForeground(Color.BLACK);
//         jButtonEditar.setText("Editar");
//         jButtonEditar.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent evt) {
//                 jButtonEditarActionPerformed(evt);
//             }
//         });

//         jLabelNovoNumero.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelNovoNumero.setText("Numero do Novo Quarto:");

//         jTextFieldNovoNome.setBackground(Color.WHITE);
//         jTextFieldNovoQuarto.setBackground(Color.WHITE);

//         jLabelIdReserva.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelIdReserva.setText("ID da Reserva editada:");

//         jTextFieldIdReserva.setBackground(Color.WHITE);

//         GroupLayout layout = new GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(73, 73, 73)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//                     .addComponent(jLabelNovoNumero)
//                     .addComponent(jLabelNovoNome)
//                     .addComponent(jLabelIdReserva))
//                 .addGap(49, 49, 49)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                     .addComponent(jTextFieldNovoQuarto)
//                     .addComponent(jTextFieldNovoNome)
//                     .addComponent(jTextFieldIdReserva, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
//                 .addContainerGap(127, Short.MAX_VALUE))
//             .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                         .addComponent(jButtonVoltar)
//                         .addGap(216, 216, 216)
//                         .addComponent(jButtonEditar)
//                         .addGap(126, 126, 126))
//                     .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                         .addComponent(jLabelEditarReserva)
//                         .addGap(218, 218, 218))))
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(20, 20, 20)
//                 .addComponent(jLabelEditarReserva)
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addComponent(jLabelIdReserva)
//                     .addComponent(jTextFieldIdReserva, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//                 .addGap(38, 38, 38)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                     .addComponent(jLabelNovoNome)
//                     .addComponent(jTextFieldNovoNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//                 .addGap(41, 41, 41)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addComponent(jLabelNovoNumero)
//                     .addComponent(jTextFieldNovoQuarto, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addComponent(jButtonVoltar)
//                     .addComponent(jButtonEditar))
//                 .addGap(37, 37, 37))
//         );

//         pack();
//     }

//     private void jButtonEditarActionPerformed(ActionEvent evt) {
//         int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
//             "Tem certeza de que deseja editar esta reserva?", 
//             "Confirmação de Edição", 
//             javax.swing.JOptionPane.YES_NO_OPTION);
    
//         if (confirm == javax.swing.JOptionPane.YES_OPTION) {
//             String idString = jTextFieldIdReserva.getText();
//             String idHospedeString = jTextFieldNovoNome.getText();
//             String quartoString = jTextFieldNovoQuarto.getText();
    
//             Id guestId = new Id(idString);
//             Id newGuest = new Id(idHospedeString);
//             RoomNumber newRoom = new RoomNumber(quartoString);
            
//             try {
//                 reserveController.editReserve(guestId, newGuest, newRoom);
//                 javax.swing.JOptionPane.showMessageDialog(this, "Reserva editada com sucesso!");    
//             } catch (Exception e) {
                
//             }
//         } else {
//             javax.swing.JOptionPane.showMessageDialog(this, "Edição cancelada.");
//         }
//     }

//     private void JButtonVoltarActionPerformed(ActionEvent evt) {
//         dispose(); 
//         new MenuReserveWindow().setVisible(true);
//     }

//     public static void main(String args[]) {
//         try {
//             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                 if ("Nimbus".equals(info.getName())) {
//                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                     break;
//                 }
//             }
//         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(EditarReservaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         }

//         java.awt.EventQueue.invokeLater(() -> new EditarReservaWindow("1", "1", "1").setVisible(true));
//     }
// }
