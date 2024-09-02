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

public class MenuRoomWindow extends JFrame {

    private JLabel jLabelMenuRoom;
    private JButton jButtonEditarRoom;
    private JButton jButtonReturn;
    private JScrollPane jScrollPaneRoom;
    private JTable jTableRoom;

    public MenuRoomWindow() {
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
                    component.setBackground(table.getBackground());
                }

                return component;
            }
        });
    }

    private void initComponents() {
        jLabelMenuRoom = new JLabel();
        jButtonEditarRoom = new JButton();
        jButtonReturn = new JButton();
        jScrollPaneRoom = new JScrollPane();
        jTableRoom = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(869, 570));
        setResizable(false);

        jLabelMenuRoom.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelMenuRoom.setText("Menu de Quartos");

        jButtonEditarRoom.setBackground(new java.awt.Color(51, 153, 255));
        jButtonEditarRoom.setFont(new java.awt.Font("Segoe UI", 0, 20)); // Ajuste o tamanho da fonte
        jButtonEditarRoom.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEditarRoom.setText("Editar Quarto");
        jButtonEditarRoom.setPreferredSize(new java.awt.Dimension(150, 40)); // Define o tamanho preferido
        jButtonEditarRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarRoomActionPerformed(evt);
            }
        });

        jButtonReturn.setBackground(new java.awt.Color(204, 204, 255));
        jButtonReturn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // Ajuste o tamanho da fonte
        jButtonReturn.setForeground(new java.awt.Color(0, 0, 0));
        jButtonReturn.setText("Voltar");
        jButtonReturn.setPreferredSize(new java.awt.Dimension(150, 40)); // Define o tamanho preferido
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        jTableRoom.setSelectionBackground(Color.CYAN);
        jTableRoom.setSelectionForeground(Color.BLUE);
        jTableRoom.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                // Linha de exemplo
                {"1", "TBD", 0, "TBD"},
                {"2", "TBD", 0, "TBD"},
                {"3", "TBD", 0, "TBD"},
                {"4", "TBD", 0, "TBD"},
                {"5", "TBD", 0, "TBD"},
                {"6", "TBD", 0, "TBD"},
                {"7", "TBD", 0, "TBD"},
                {"8", "TBD", 0, "TBD"},
                {"9", "TBD", 0, "TBD"},
                {"10", "TBD", 0, "TBD"},
                {"11", "TBD", 0, "TBD"},
                {"12", "TBD", 0, "TBD"},
                {"13", "TBD", 0, "TBD"},
                {"14", "TBD", 0, "TBD"},
                {"15", "TBD", 0, "TBD"},
                {"16", "TBD", 0, "TBD"},
                {"17", "TBD", 0, "TBD"},
                {"18", "TBD", 0, "TBD"},
                {"19", "TBD", 0, "TBD"},
                {"20", "TBD", 0, "TBD"},
                
            },
            new String [] {
                "Número", "Tipo", "Capacidade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
                        .addComponent(jButtonEditarRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(jButtonEditarRoom)
                    .addComponent(jButtonReturn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonEditarRoomActionPerformed(java.awt.event.ActionEvent evt) {
        // Adicione a lógica para editar quarto
    }

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {
        // Adicione a lógica para voltar
    }

    private void setTableModel() {
        // Adicione lógica para atualizar o modelo da tabela, se necessário
    }

    private void atualizarTabela() {
        // Adicione lógica para atualizar a tabela, se necessário
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
            java.util.logging.Logger.getLogger(MenuRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuRoomWindow().setVisible(true);
            }
        });
    }
}