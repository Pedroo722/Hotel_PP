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

public class ReserveWindow extends JFrame {

    private JLabel jLabelMenuReserve;
    private JButton jButtonAddReserve;
    private JButton jButtonRemoveReserve;
    private JButton jButtonReturn;
    private JButton jButtonEditarReserve;
    private JScrollPane jScrollPaneReserve;
    private JTable jTableReserve;


    public ReserveWindow() {
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

        jTableReserve.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        jLabelMenuReserve = new JLabel();
        jButtonAddReserve = new JButton();
        jButtonRemoveReserve = new JButton();
        jButtonReturn = new JButton();
        jButtonEditarReserve = new JButton();
        jScrollPaneReserve = new JScrollPane();
        jTableReserve = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(869, 570));
        setName("frMainWindow");
        setPreferredSize(new java.awt.Dimension(869, 570));
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
        jTableReserve.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTableReserve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nenhuma", "reserva", "cadastrada.", null, null},
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
                "ID", "Cliente", "Quarto", "loremipsu", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableReserve.setFillsViewportHeight(true);
        jScrollPaneReserve.setViewportView(jTableReserve);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRemoveReserve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddReserve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonReturn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonEditarReserve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(142, 142, 142))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup
()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMenuReserve)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMenuReserve)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddReserve)
                    .addComponent(jButtonEditarReserve))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveReserve)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonAddReserveActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void jButtonRemoveReserveActionPerformed(java.awt.event.ActionEvent evt) {
        //
    }

    private void jButtonEditarReserveActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(ReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReserveWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReserveWindow().setVisible(true);
            }
        });
    }
}