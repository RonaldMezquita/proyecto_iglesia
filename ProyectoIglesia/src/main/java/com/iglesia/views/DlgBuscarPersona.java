/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.PersonaController;
import com.iglesia.entities.Persona;
import com.iglesia.utils.TextPrompt;
import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author remsf
 */
public class DlgBuscarPersona extends javax.swing.JDialog {

    private PersonaController personaController;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    /**
     * Creates new form DlgBuscarPersona
     */
    public DlgBuscarPersona(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.personaController = new PersonaController();
        this.mostrarTabla("");
        new TextPrompt("Digite para buscar en nombres o apellidos", this.txtBuscar);
        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void mostrarTabla(String filtro) {
        this.personaController.llenarTablaBusqueda(tbpersona, filtro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpersona = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(520, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(158, 158, 158));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbpersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "DUI", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbpersona.setRowHeight(25);
        tbpersona.getTableHeader().setReorderingAllowed(false);
        tbpersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpersona);
        if (tbpersona.getColumnModel().getColumnCount() > 0) {
            tbpersona.getColumnModel().getColumn(0).setMinWidth(30);
            tbpersona.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbpersona.getColumnModel().getColumn(0).setMaxWidth(45);
            tbpersona.getColumnModel().getColumn(3).setResizable(false);
            tbpersona.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbpersona.getColumnModel().getColumn(4).setMinWidth(25);
            tbpersona.getColumnModel().getColumn(4).setPreferredWidth(25);
            tbpersona.getColumnModel().getColumn(4).setMaxWidth(25);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 480, 250));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 390, -1));

        jLabel1.setText("Haga click en el boton seleccionar para elegir una persona");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 340, -1));

        jbCerrar.setBackground(new java.awt.Color(204, 0, 0));
        jbCerrar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrar.setText("X");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbpersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpersonaMouseClicked
        int column = this.tbpersona.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.tbpersona.getRowHeight();

        if (row < this.tbpersona.getRowCount() && row >= 0
                && column < this.tbpersona.getColumnCount() && column >= 0) {
            Object value = this.tbpersona.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                Integer id = Integer.parseInt(this.tbpersona.getValueAt(row, 0).toString());
                this.persona = this.personaController.consultarPorId(id);
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }//GEN-LAST:event_tbpersonaMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.mostrarTabla(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgBuscarPersona dialog = new DlgBuscarPersona(new javax.swing.JDialog(), true
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JTable tbpersona;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
