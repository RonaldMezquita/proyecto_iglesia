/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.SacerdoteController;
import com.iglesia.entities.Sacerdote;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.ProjectUtils;
import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author remsf
 */
public class DlgBuscarSacerdote extends javax.swing.JDialog {

    private SacerdoteController sacerdoteController;
    private Sacerdote sacerdote;
    private javax.swing.JFormattedTextField txtBuscarDui;

    public Sacerdote getSacerdote() {
        return sacerdote;
    }

    /**
     * Creates new form DlgBuscarSacerdote
     */
    public DlgBuscarSacerdote(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.sacerdoteController = new SacerdoteController();
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
//        new TextPrompt("Digite nombres, apellidos o DUI para realizar la busqueda", this.txtBuscar);
        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.txtBuscar.requestFocus();
        this.loadTxtBuscarDui();
//        getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Metodo para cargar el JTextField para buscar por DUI
     */
    private void loadTxtBuscarDui() {
        this.txtBuscarDui = ProjectUtils.getCampoDui();
        this.txtBuscarDui.setName("dui");
        this.txtBuscarDui.setFont(new java.awt.Font("Dialog", 0, 12));
        this.txtBuscarDui.setVisible(false);
        this.txtBuscarDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarDuiKeyReleased(evt);
            }
        });
        jPanel1.add(this.txtBuscarDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, -1));
    }

    private void mostrarTabla(String filtro, TipoBusquedaEnum tipo) {
        this.sacerdoteController.llenarTablaBusqueda(tbSacerdote, filtro, tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBusqueda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSacerdote = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();
        btnNuevoSacerdote = new javax.swing.JButton();
        rbNombre = new javax.swing.JRadioButton();
        rbDui = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(520, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSacerdote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Completo", "DUI", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSacerdote.setRowHeight(25);
        tbSacerdote.getTableHeader().setReorderingAllowed(false);
        tbSacerdote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSacerdoteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSacerdote);
        if (tbSacerdote.getColumnModel().getColumnCount() > 0) {
            tbSacerdote.getColumnModel().getColumn(0).setMinWidth(30);
            tbSacerdote.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbSacerdote.getColumnModel().getColumn(0).setMaxWidth(45);
            tbSacerdote.getColumnModel().getColumn(2).setMinWidth(90);
            tbSacerdote.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbSacerdote.getColumnModel().getColumn(2).setMaxWidth(90);
            tbSacerdote.getColumnModel().getColumn(3).setMinWidth(25);
            tbSacerdote.getColumnModel().getColumn(3).setPreferredWidth(25);
            tbSacerdote.getColumnModel().getColumn(3).setMaxWidth(25);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 480, 250));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/x26-listar.png"))); // NOI18N
        jLabel1.setText("Haga click en el boton seleccionar para elegir un sacerdote");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 370, -1));

        jbCerrar.setBackground(new java.awt.Color(204, 0, 0));
        jbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrar.setText("X");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 40, 32));

        btnNuevoSacerdote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/x26-addUser.png"))); // NOI18N
        btnNuevoSacerdote.setText("Registrar nuevo sacedote");
        btnNuevoSacerdote.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoSacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoSacerdoteActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoSacerdote, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 90, -1, -1));

        bgBusqueda.add(rbNombre);
        rbNombre.setForeground(new java.awt.Color(255, 255, 255));
        rbNombre.setSelected(true);
        rbNombre.setText("Buscar por Nombre");
        rbNombre.setName(""); // NOI18N
        rbNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbNombreMouseClicked(evt);
            }
        });
        jPanel1.add(rbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 72, -1, -1));

        bgBusqueda.add(rbDui);
        rbDui.setForeground(new java.awt.Color(255, 255, 255));
        rbDui.setText("Buscar por DUI");
        rbDui.setName(""); // NOI18N
        rbDui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbDuiMouseClicked(evt);
            }
        });
        jPanel1.add(rbDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 72, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Busqueda de Sacerdote");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSacerdoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSacerdoteMouseClicked
        int column = this.tbSacerdote.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.tbSacerdote.getRowHeight();

        if (row < this.tbSacerdote.getRowCount() && row >= 0
                && column < this.tbSacerdote.getColumnCount() && column >= 0) {
            Object value = this.tbSacerdote.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                Integer id = Integer.parseInt(this.tbSacerdote.getValueAt(row, 0).toString());
                this.sacerdote = this.sacerdoteController.consultarPorId(id);
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }//GEN-LAST:event_tbSacerdoteMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.mostrarTabla(this.txtBuscar.getText(), TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarDuiKeyReleased(java.awt.event.KeyEvent evt) {
        this.mostrarTabla(this.txtBuscarDui.getText(), TipoBusquedaEnum.DUI);
    }

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void btnNuevoSacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoSacerdoteActionPerformed
        DlgSacerdote obj = new DlgSacerdote(null, true);
        obj.setVisible(true);
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_btnNuevoSacerdoteActionPerformed

    private void rbNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNombreMouseClicked
        this.txtBuscarDui.setText("");
        this.txtBuscarDui.setVisible(false);
        this.txtBuscar.setText("");
        this.txtBuscar.setVisible(true);
        this.txtBuscar.requestFocus();
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_rbNombreMouseClicked

    private void rbDuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbDuiMouseClicked
        this.txtBuscar.setText("");
        this.txtBuscarDui.setText("");
        this.txtBuscar.setVisible(false);
        this.txtBuscarDui.setVisible(true);
        this.txtBuscarDui.requestFocus();
        this.mostrarTabla("", TipoBusquedaEnum.DUI);
    }//GEN-LAST:event_rbDuiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgBuscarSacerdote dialog = new DlgBuscarSacerdote(new javax.swing.JDialog(), true
                );
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBusqueda;
    private javax.swing.JButton btnNuevoSacerdote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JRadioButton rbDui;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JTable tbSacerdote;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
