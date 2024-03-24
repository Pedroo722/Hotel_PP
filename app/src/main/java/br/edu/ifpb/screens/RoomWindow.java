package br.edu.ifpb.screens;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RoomWindow extends JFrame {

    private JLabel jLabelMenuRoom;
    private JButton jButtonAddRoom;
    private JButton jButtonRemoveRoom;
    private JButton jButtonReturn;
    private JButton jButtonEditarRoom;
    private JScrollPane jScrollPaneRoom;
    private JTable jTableRoom;


    public RoomWindow() {
        initComponents();
        setTableModel();
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                atualizarTabela();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
            }
        });

        jTableRoom.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        jLabelMenuRoom = new JLabel();
        jButtonAddRoom = new JButton();
        jButtonRemoveRoom = new JButton();
        jButtonReturn = new JButton();
        jButtonEditarRoom = new JButton();
        jScrollPaneRoom = new JScrollPane();
        jTableRoom = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelMenuRoom.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelMenuRoom.setText("Menu de Quartos");

        jButtonAddRoom.setBackground(new java.awt.Color(51, 153, 255));
        jButtonAddRoom.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonAddRoom.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddRoom.setText("Cadastrar Quarto");
        jButtonAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRoomActionPerformed(evt);
            }
        });

        jButtonRemoveRoom.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRemoveRoom.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonRemoveRoom.setForeground(new java.awt.Color(51, 51, 51));
        jButtonRemoveRoom.setText("Remover Quarto");
        jButtonRemoveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveRoomActionPerformed(evt);
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
        

        jButtonEditarRoom.setBackground(new java.awt.Color(51, 153, 255));
        jButtonEditarRoom.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jButtonEditarRoom.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEditarRoom.setText("Editar Quarto");
        jButtonEditarRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarRoomActionPerformed(evt);
            }
        });

        jTableRoom.setSelectionBackground(Color.CYAN);
        jTableRoom.setSelectionForeground(Color.BLUE);
        jTableRoom.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nenhum", "quarto", "cadastrado.", null, null},
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
                "ID", "Numero", "Tamanho", "Capacidade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableRoom.setFillsViewportHeight(true);
        jScrollPaneRoom.setViewportView(jTableRoom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRemoveRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonReturn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonEditarRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(142, 142, 142))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup
()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuRoom)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMenuRoom)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRoom)
                    .addComponent(jButtonEditarRoom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveRoom)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonAddRoomActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void jButtonRemoveRoomActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void jButtonEditarRoomActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void setTableModel() {
        
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
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomWindow().setVisible(true);
            }
        });
    }
}