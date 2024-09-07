package br.edu.ifpb.screens;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpb.db.DataBaseManager;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.presenter.controller.GuestController;

public class MenuGuestWindow extends JFrame {
    private JLabel jLabelMenuGuest;
    private JButton jButtonAddGuest;
    private JButton jButtonRemoveGuest;
    private JButton jButtonReturn;
    private JButton jButtonEditarGuest;
    private JScrollPane jScrollPaneGuest;
    private JTable jTableGuest;
    private GuestController guestController;

    public MenuGuestWindow() {
        initComponents();
        setTableModel();
        setLocationRelativeTo(null);
        DataBaseManager.initialize();
        guestController = new GuestController();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                atualizarTabela();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
            }
        });

        jTableGuest.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) { 
                    component.setBackground(new Color(173, 216, 230)); // Azul claro
                    
                } else {
                    // Se não estiver selecionado, use a cor padrão de fundo
                    component.setBackground(table.getBackground());
                }

                return component;
            }
        });
    }

    private void initComponents() {
        jLabelMenuGuest = new JLabel();
        jButtonAddGuest = new JButton();
        jButtonRemoveGuest = new JButton();
        jButtonReturn = new JButton();
        jButtonEditarGuest = new JButton();
        jScrollPaneGuest = new JScrollPane();
        jTableGuest = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelMenuGuest.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelMenuGuest.setText("Menu de Hóspedes");

        jButtonAddGuest.setBackground(new java.awt.Color(51, 153, 255));
        jButtonAddGuest.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAddGuest.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddGuest.setText("Cadastrar Hóspede");
        jButtonAddGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGuestActionPerformed(evt);
            }
        });

        jButtonRemoveGuest.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRemoveGuest.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonRemoveGuest.setForeground(new java.awt.Color(51, 51, 51));
        jButtonRemoveGuest.setText("Remover Hóspede");
        jButtonRemoveGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveGuestActionPerformed(evt);
            }
        });

        jButtonReturn.setBackground(new java.awt.Color(204, 204, 255));
        jButtonReturn.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonReturn.setForeground(new java.awt.Color(0, 0, 0));
        jButtonReturn.setText("Voltar");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });
        

        jButtonEditarGuest.setBackground(new java.awt.Color(51, 153, 255));
        jButtonEditarGuest.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditarGuest.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEditarGuest.setText("Editar Hóspede");
        jButtonEditarGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarGuestActionPerformed(evt);
            }
        });

        jTableGuest.setSelectionBackground(Color.CYAN);
        jTableGuest.setSelectionForeground(Color.BLUE);
        jTableGuest.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nenhum", "hóspede", "cadastrado.", null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Hóspede", "Nome", "CPF", "ID Reserva", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableGuest.setFillsViewportHeight(true);
        jScrollPaneGuest.setViewportView(jTableGuest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRemoveGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonReturn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonEditarGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(142, 142, 142))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup
()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuGuest)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMenuGuest)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddGuest)
                    .addComponent(jButtonEditarGuest))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveGuest)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonAddGuestActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new CadastrarHospedeWindow().setVisible(true);
    }

    private void jButtonRemoveGuestActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTableGuest.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                    "Tem certeza de que deseja remover o hóspede selecionado?", 
                    "Confirmação", javax.swing.JOptionPane.YES_NO_OPTION);
            
            if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                String guestId = jTableGuest.getValueAt(selectedRow, 0).toString();
                guestController.removeGuest(new Id(guestId));
                atualizarTabela();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um hóspede para remover.");
        }
    }

    private void jButtonEditarGuestActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTableGuest.getSelectedRow(); 
        if (selectedRow != -1) { 
            String guestId = jTableGuest.getValueAt(selectedRow, 0).toString(); 
            String name = jTableGuest.getValueAt(selectedRow, 1).toString(); 
            String cpf = jTableGuest.getValueAt(selectedRow, 2).toString(); 

            dispose(); 
            EditarHospedeWindow editarHospedeWindow = new EditarHospedeWindow(guestId, name, cpf);
            editarHospedeWindow.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um hóspede para editar.");
        }
    }

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new MainMenuWindow().setVisible(true);
    }

    private void setTableModel() {
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Hóspede", "Nome", "CPF", "ID Reserva", "Status"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, Integer.class, String.class 
            };
    
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
    
        jTableGuest.setModel(model);
    }

    // Adicione esta classe StatusCellRenderer
    class StatusCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String status = value.toString();

            if (isSelected) {
                component.setBackground(new Color(173, 216, 230)); // Azul claro quando selecionado
            } else if ("Baixa Quantidade".equals(status)) {
                component.setBackground(Color.RED);
            } else if ("Alta Quantidade".equals(status)) {
                component.setBackground(Color.GREEN);
            } else {
                component.setBackground(Color.WHITE);
            }

            return component;
        }
    }


    private void atualizarTabela() {
        List<Guest> guests = guestController.getListGuests();
        DefaultTableModel model = (DefaultTableModel) jTableGuest.getModel();
        model.setRowCount(0);
    
        for (Guest guest : guests) {
            Object[] rowData = new Object[] {
                guest.getUserId() != null ? guest.getUserId().getValue() : "N/A", 
                guest.getName() != null ? guest.getName() : "N/A",
                guest.getCpf() != null ? guest.getCpf() : "N/A",
                guest.getReserveId() != null ? guest.getReserveId().getValue() : "N/A",
                guest.getStatus() != null ? guest.getStatus() : "N/A"
            };
            model.addRow(rowData);
        }
    }

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGuestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGuestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGuestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGuestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGuestWindow().setVisible(true);
            }
        });
    }
}