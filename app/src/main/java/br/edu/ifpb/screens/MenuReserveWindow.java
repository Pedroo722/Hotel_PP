package br.edu.ifpb.screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import br.edu.ifpb.db.DataBaseManager;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.*;
import javax.swing.JToggleButton; 

public class MenuReserveWindow extends JFrame {
    private JLabel jLabelMenuReserve;
    private JButton jButtonAddReserve;
    private JButton jButtonRemoveReserve;
    private JButton jButtonReturn;
    private JButton jButtonEditarReserve;
    private JScrollPane jScrollPaneReserve;
    private JTable jTableReserve;
    private ReserveController reserveController;
    private GuestController guestController;
    private RoomController roomController;
    private JToggleButton jToggleButtonActive; 
    private JToggleButton jToggleButtonFinished; 

    public MenuReserveWindow() {
        initComponents();
        setTableModel();
        setLocationRelativeTo(null);
        DataBaseManager.initialize();
        reserveController = new ReserveController();
        guestController = new GuestController();
        roomController = new RoomController();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                atualizarTabela(); 
            }
        });

        jToggleButtonActive.addActionListener(e -> atualizarTabela()); 
        jToggleButtonFinished.addActionListener(e -> atualizarTabela()); 

        jTableReserve.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    component.setBackground(new Color(173, 216, 230)); 
                } else {
                    component.setBackground(table.getBackground());
                }
                return component;
            }
        });

        jTableReserve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTableReserve.rowAtPoint(e.getPoint());
                int column = jTableReserve.columnAtPoint(e.getPoint());

                if (row >= 0 && row < jTableReserve.getRowCount() && column >= 0 && column < jTableReserve.getColumnCount()) {
                    if (column == 2) { 
                        String guestId = jTableReserve.getValueAt(row, column).toString();
                        showGuestDetails(guestId);
                    } else if (column == 1) { 
                        String roomNumber = jTableReserve.getValueAt(row, column).toString();
                        showRoomDetails(roomNumber);
                    }
                }
            }
        });
    }

    private void initComponents() {
        jLabelMenuReserve = new JLabel();
        jButtonAddReserve = new JButton();
        jButtonRemoveReserve = new JButton();
        jButtonReturn = new JButton();
        jButtonEditarReserve = new JButton();
        jScrollPaneReserve = new JScrollPane();
        jTableReserve = new JTable();
        jToggleButtonActive = new JToggleButton("Reservas Ativas");
        jToggleButtonFinished = new JToggleButton("Reservas Finalizadas");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(900, 570));
        setResizable(false);

        jLabelMenuReserve.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelMenuReserve.setText("Menu de Reservas");

        jButtonAddReserve.setBackground(new java.awt.Color(51, 153, 255));
        jButtonAddReserve.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAddReserve.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddReserve.setText("Cadastrar Reserva");
        jButtonAddReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddReserveActionPerformed(evt);
            }
        });

        jButtonRemoveReserve.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRemoveReserve.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonRemoveReserve.setForeground(new java.awt.Color(51, 51, 51));
        jButtonRemoveReserve.setText("Remover Reserva");
        jButtonRemoveReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveReserveActionPerformed(evt);
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

        jButtonEditarReserve.setBackground(new java.awt.Color(51, 153, 255));
        jButtonEditarReserve.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditarReserve.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEditarReserve.setText("Editar Reserva");
        jButtonEditarReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarReserveActionPerformed(evt);
            }
        });

        jTableReserve.setSelectionBackground(Color.CYAN);
        jTableReserve.setSelectionForeground(Color.BLUE);
        jTableReserve.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTableReserve.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Reserva", "Número de Quarto", "ID Hóspede", "Check-In", "Check-Out", "Status"
            }
        ));
        jScrollPaneReserve.setViewportView(jTableReserve);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddReserve)
                        .addGap(129, 129, 129)
                        .addComponent(jButtonEditarReserve))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRemoveReserve)
                        .addGap(129, 129, 129)
                        .addComponent(jButtonReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButtonActive)
                        .addGap(129, 129, 129)
                        .addComponent(jToggleButtonFinished)))
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuReserve)
                .addGap(319, 319, 319))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelMenuReserve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddReserve)
                    .addComponent(jButtonEditarReserve))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveReserve)
                    .addComponent(jButtonReturn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonActive)
                    .addComponent(jToggleButtonFinished))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReserve, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );

        pack();
    }

    private void atualizarTabela() {
        List<Reserve> reserves = reserveController.getListReserves();
        DefaultTableModel model = (DefaultTableModel) jTableReserve.getModel();
        model.setRowCount(0);

        for (Reserve reserve : reserves) {
            boolean isActive = reserve.getStatus() == ReserveStatus.ACTIVE;
            if (jToggleButtonActive.isSelected() && isActive || jToggleButtonFinished.isSelected() && !isActive) {
                Object[] rowData = new Object[] {
                    reserve.getReserveId() != null ? reserve.getReserveId().toString() : "N/A",
                    reserve.getNumber() != null ? reserve.getNumber().toString() : "N/A",
                    reserve.getUserId() != null ? reserve.getUserId().toString() : "N/A",
                    reserve.getCheckIn() != null ? reserve.getCheckIn().toString() : "N/A",
                    reserve.getCheckOut() != null ? reserve.getCheckOut().toString() : "N/A",
                    reserve.getStatus().toString()
                };
                model.addRow(rowData);
            }
        }
    }

    private void jButtonAddReserveActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new CadastrarReservaWindow().setVisible(true);
    }
    
    private void jButtonEditarReserveActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTableReserve.getSelectedRow(); 
        if (selectedRow != -1) { 
            String reserveId = jTableReserve.getValueAt(selectedRow, 0).toString(); 
            String guestId = jTableReserve.getValueAt(selectedRow, 1).toString(); 
            String roomNumber = jTableReserve.getValueAt(selectedRow, 2).toString(); 

            dispose(); 
            EditarReservaWindow editarReservaWindow = new EditarReservaWindow(reserveId, guestId, roomNumber);
            editarReservaWindow.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um hóspede para editar.");
        }
    }

    private void jButtonRemoveReserveActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTableReserve.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                    "Tem certeza de que deseja remover a reserva selecionada?", 
                    "Confirmação", javax.swing.JOptionPane.YES_NO_OPTION);
            
            if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                String reserveId = jTableReserve.getValueAt(selectedRow, 0).toString();
                reserveController.removeReserve(new Id(reserveId));
                atualizarTabela();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um hóspede para remover.");
        }
    }

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); 
        new MainMenuWindow().setVisible(true);
    }
    
    private void setTableModel() {
        jTableReserve.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Reserva ID", "Número de Quarto", "Hóspede ID", "Check-In", "Check-Out", "Status"
            }
        ));
    }

    private void showRoomDetails(String stringNumber) {
        RoomNumber roomNumber = new RoomNumber(stringNumber);
        Room room = roomController.getRoomByNumber(roomNumber);
    
        String roomDescription = "";
        String roomCapacity = "";
    
        Id roomTypeId = room.getRoomTypeId();
        if (roomTypeId.getValue() == 1) {
            roomDescription = RoomType.getSmallRoomDescription();
            roomCapacity = RoomType.getSmallRoomCapacity();
        } else if (roomTypeId.getValue() == 2) {
            roomDescription = RoomType.getMediumRoomDescription();
            roomCapacity = RoomType.getMediumRoomCapacity();
        } else if (roomTypeId.getValue() == 3) {
            roomDescription = RoomType.getLargeRoomDescription();
            roomCapacity = RoomType.getLargeRoomCapacity();
        } else if (roomTypeId.getValue() == 4) {
            roomDescription = RoomType.getDeluxeRoomDescription();
            roomCapacity = RoomType.getDeluxeRoomCapacity();
        }
    
        JDialog dialog = new JDialog(this, "Detalhes do Quarto", true);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(this);
    
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("ID do Quarto: " + room.getRoomId() + "\n"
                        + "Número do Quarto: " + room.getNumber() + "\n"
                        + "Capacidade: " + roomCapacity + "\n"
                        + "Descrição do Tipo de Quarto: " + roomDescription + "\n"
                        + "Status: " + room.getStatus());
        
        dialog.add(textArea);
        dialog.setVisible(true);
    }

    private void showGuestDetails(String guestId) {
        Guest guest = guestController.getGuestById(new Id(guestId));
        
        if (guest == null) {
            JOptionPane.showMessageDialog(this, "Hóspede não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JDialog dialog = new JDialog(this, "Detalhes do Hóspede", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("ID do Hóspede: " + guest.getUserId() + "\n"
                        + "Nome: " + guest.getName() + "\n"
                        + "CPF: " + guest.getCpf() + "\n"
                        + "Status: " + guest.getStatus());
        
        dialog.add(new JScrollPane(textArea));
        dialog.setVisible(true);
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
            java.util.logging.Logger.getLogger(MenuReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuReserveWindow().setVisible(true);
            }
        });
    }
}
