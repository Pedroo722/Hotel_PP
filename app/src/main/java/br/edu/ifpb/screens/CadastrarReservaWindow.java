package br.edu.ifpb.screens;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import br.edu.ifpb.db.DataBaseManager;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.model.services.BreakFastService;
import br.edu.ifpb.domain.model.services.PetCareService;
import br.edu.ifpb.domain.model.services.SpaService;
import br.edu.ifpb.domain.model.services.TourismGuideService;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.ReserveController;
import br.edu.ifpb.presenter.controller.ServiceController;

public class CadastrarReservaWindow extends javax.swing.JFrame {
    private JLabel jLabelAdicionarReserva;
    private JLabel jLabelID;
    private JLabel jLabelNumero;
    private JButton jButtonVoltar;
    private JButton jButtonCadastrar;
    private JTextField jTextFieldID;
    private JTextField jTextFieldNumero;
    private ReserveController reserveController;
    private ServiceController serviceController;

    
    private JCheckBox jCheckBoxServiço1;
    private JCheckBox jCheckBoxServiço2;
    private JCheckBox jCheckBoxServiço3;
    private JCheckBox jCheckBoxServiço4;
    private JLabel jLabelServicosAdicionais;

    public CadastrarReservaWindow() {
        initComponents();
        setLocationRelativeTo(null);
        DataBaseManager.initialize();
        serviceController = new ServiceController();
        reserveController = new ReserveController();
    }

    private void initComponents() {
        jLabelAdicionarReserva = new JLabel();
        jLabelID = new JLabel();
        jLabelNumero = new JLabel();
        jButtonVoltar = new JButton();
        jButtonCadastrar = new JButton();
        jTextFieldID = new JTextField();
        jTextFieldNumero = new JTextField();
        
        jCheckBoxServiço1 = new JCheckBox("Serviço de Café da Manhã");
        jCheckBoxServiço2 = new JCheckBox("Serviço de Pet Care");
        jCheckBoxServiço3 = new JCheckBox("Serviço de Spa");
        jCheckBoxServiço4 = new JCheckBox("Serviço de Guia Turístico");

        jLabelServicosAdicionais = new JLabel("Serviços Adicionais:");
        jLabelServicosAdicionais.setFont(new java.awt.Font("Segoe UI", 0, 24));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(869, 570));
        setMinimumSize(new java.awt.Dimension(869, 570));
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelAdicionarReserva.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelAdicionarReserva.setText("Adicionar Reserva");

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelID.setText("ID do Hóspede:");

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabelNumero.setText("Número do Quarto:");

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

        jTextFieldID.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNumero.setBackground(new java.awt.Color(255, 255, 255));

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
                        .addComponent(jLabelAdicionarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelID)
                                .addComponent(jLabelNumero))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jTextFieldNumero))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelServicosAdicionais)
                        .addGap(125, 125, 125)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxServiço1)
                    .addComponent(jCheckBoxServiço2))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxServiço3)
                    .addComponent(jCheckBoxServiço4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelAdicionarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelServicosAdicionais) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxServiço1)
                    .addComponent(jCheckBoxServiço3)) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxServiço2)
                    .addComponent(jCheckBoxServiço4)) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String idString = jTextFieldID.getText();
        String numeroString = jTextFieldNumero.getText();

        Id guestId = new Id(idString);
        RoomNumber roomNumber = new RoomNumber(numeroString);

        Service service = new Service();

        boolean hasBreakfast = jCheckBoxServiço1.isSelected();
        boolean hasPetCare = jCheckBoxServiço2.isSelected();
        boolean hasSpa = jCheckBoxServiço3.isSelected();
        boolean hasTourism = jCheckBoxServiço4.isSelected(); 

        if (hasBreakfast) {
            service.addService(new BreakFastService(service.getServices()));
        }

        if (hasPetCare) {
            service.addService(new PetCareService(service.getServices()));
        }

        if (hasSpa) {
            service.addService(new SpaService(service.getServices()));
        }

        if (hasTourism) {
            service.addService(new TourismGuideService(service.getServices()));
        }

        try {
            serviceController.addService(service);
            reserveController.addReserve(guestId, roomNumber, service.getServiceId());
            javax.swing.JOptionPane.showMessageDialog(this, "Reserva criada com sucesso!");    
        } catch (RuntimeException e) {

        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new MenuReserveWindow().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarReservaWindow().setVisible(true);
        });
    }
}
