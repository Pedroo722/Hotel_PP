// package br.edu.ifpb.screens;

// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.JTextField;
// import javax.swing.GroupLayout;
// import javax.swing.WindowConstants;

// import br.edu.ifpb.db.DataBaseManager;
// import br.edu.ifpb.presenter.controller.GuestController;
// import br.edu.ifpb.domain.wrappers.*;

// import java.awt.Dimension;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class EditarHospedeWindow extends javax.swing.JFrame {
//     private javax.swing.JButton jButtonEditar;
//     private javax.swing.JButton jButtonVoltar;
//     private javax.swing.JLabel jLabelEditarHospede;
//     private javax.swing.JLabel jLabelIdHospede;
//     private javax.swing.JLabel jLabelNovoNome;
//     private javax.swing.JLabel jLabelNovoCpf;
//     private javax.swing.JTextField jTextFieldIdHospede;
//     private javax.swing.JTextField jTextFieldNovoNome;
//     private javax.swing.JTextField jTextFieldNovoCpf;
//     private GuestController guestController;

//     public EditarHospedeWindow(String idHospede, String nomeHospede, String cpfHospede) {
//         initComponents();
//         setLocationRelativeTo(null);
//         DataBaseManager.initialize();
//         guestController = new GuestController();

//         jTextFieldIdHospede.setText(idHospede);
//         jTextFieldNovoNome.setText(nomeHospede);
//         jTextFieldNovoCpf.setText(cpfHospede);

//         jTextFieldIdHospede.setEditable(false);

//         addWindowListener(new java.awt.event.WindowAdapter() {
//             @Override
//             public void windowClosing(java.awt.event.WindowEvent evt) {

//             }
//         });
//     }

//     private void initComponents() {
//         jLabelEditarHospede = new JLabel();
//         jLabelNovoNome = new JLabel();
//         jButtonVoltar = new JButton();
//         jButtonEditar = new JButton();
//         jLabelNovoCpf = new JLabel();
//         jTextFieldNovoNome = new JTextField();
//         jTextFieldNovoCpf = new JTextField();
//         jLabelIdHospede = new JLabel();
//         jTextFieldIdHospede = new JTextField();

//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setMaximumSize(new Dimension(869, 570));
//         setMinimumSize(new Dimension(869, 570));
//         setPreferredSize(new Dimension(869, 570));
//         setResizable(false);

//         jLabelEditarHospede.setFont(new Font("Segoe UI", Font.BOLD, 36));
//         jLabelEditarHospede.setText("Editar Hospede");

//         jLabelNovoNome.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelNovoNome.setText("Novo Nome:");

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

//         jLabelNovoCpf.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelNovoCpf.setText("Novo CPF:");

//         jTextFieldNovoNome.setBackground(Color.WHITE);
//         jTextFieldNovoCpf.setBackground(Color.WHITE);

//         jLabelIdHospede.setFont(new Font("Segoe UI", Font.PLAIN, 24));
//         jLabelIdHospede.setText("ID do Hospede editado:");

//         jTextFieldIdHospede.setBackground(Color.WHITE);

//         GroupLayout layout = new GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(73, 73, 73)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//                     .addComponent(jLabelNovoCpf)
//                     .addComponent(jLabelNovoNome)
//                     .addComponent(jLabelIdHospede))
//                 .addGap(49, 49, 49)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                     .addComponent(jTextFieldNovoCpf)
//                     .addComponent(jTextFieldNovoNome)
//                     .addComponent(jTextFieldIdHospede, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
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
//                         .addComponent(jLabelEditarHospede)
//                         .addGap(218, 218, 218))))
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addGap(20, 20, 20)
//                 .addComponent(jLabelEditarHospede)
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addComponent(jLabelIdHospede)
//                     .addComponent(jTextFieldIdHospede, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//                 .addGap(38, 38, 38)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                     .addComponent(jLabelNovoNome)
//                     .addComponent(jTextFieldNovoNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
//                 .addGap(41, 41, 41)
//                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                     .addComponent(jLabelNovoCpf)
//                     .addComponent(jTextFieldNovoCpf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
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
//             "Tem certeza de que deseja editar este hóspede?", 
//             "Confirmação de Edição", 
//             javax.swing.JOptionPane.YES_NO_OPTION);
    
//         if (confirm == javax.swing.JOptionPane.YES_OPTION) {
//             String idString = jTextFieldIdHospede.getText();
//             String nomeString = jTextFieldNovoNome.getText();
//             String cpfString = jTextFieldNovoCpf.getText();
    
//             Id guestId = new Id(idString);
//             Name novoNome = new Name(nomeString);
//             CPF novoCpf = new CPF(cpfString);
            
//             try {
//                 guestController.editGuest(guestId, novoNome, novoCpf);
//                 javax.swing.JOptionPane.showMessageDialog(this, "Hóspede editado com sucesso!");    
//             } catch (Exception e) {
                
//             }
//         } else {
//             javax.swing.JOptionPane.showMessageDialog(this, "Edição cancelada.");
//         }
//     }
    

//     private void JButtonVoltarActionPerformed(ActionEvent evt) {
//         dispose(); 
//         new MenuGuestWindow().setVisible(true);
//     }

//     public static void main(String args[]) {
//         java.awt.EventQueue.invokeLater(() -> new EditarHospedeWindow("1", "Nome Exemplo", "123.456.789-00").setVisible(true));
//     }
// }
