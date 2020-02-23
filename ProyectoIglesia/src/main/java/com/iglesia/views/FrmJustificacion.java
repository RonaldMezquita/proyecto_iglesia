/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.JustificacionController;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class FrmJustificacion extends javax.swing.JFrame {

    /**
     * Creates new form FrmJustificacion
     */
    private JustificacionController justificacionController;
    private List<String> excepciones = new ArrayList<>();

    public FrmJustificacion() {
        initComponents();
        this.justificacionController = new JustificacionController();
        this.txtid.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarTabla("");
        this.excepciones.add("buscar");
        this.txtnombre.requestFocus();
        new TextPrompt("Digite nombre para buscar", this.txtbuscar);

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
        jLabel1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        cbestado = new javax.swing.JCheckBox();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtJustificacion = new javax.swing.JTable();
        jbingresar = new javax.swing.JButton();
        jblimpiar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(189, 189, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Justificación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, -1));

        lbNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbNombre.setText("Nombre");
        jPanel1.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, -1));

        lbEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(0, 0, 0));
        lbEstado.setText("Estado");
        jPanel1.add(lbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        txtnombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 360, -1));

        cbestado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbestado.setForeground(new java.awt.Color(0, 0, 0));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, -1));

        txtbuscar.setToolTipText("");
        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 350, -1));

        jtJustificacion.setBackground(new java.awt.Color(224, 224, 224));
        jtJustificacion.setForeground(new java.awt.Color(0, 0, 0));
        jtJustificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtJustificacion.setSelectionBackground(new java.awt.Color(189, 189, 189));
        jtJustificacion.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtJustificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtJustificacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtJustificacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 350, 180));

        jbingresar.setBackground(new java.awt.Color(13, 71, 161));
        jbingresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbingresar.setForeground(new java.awt.Color(255, 255, 255));
        jbingresar.setText("Guardar");
        jbingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbingresarActionPerformed(evt);
            }
        });
        jPanel1.add(jbingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, -1));

        jblimpiar.setBackground(new java.awt.Color(255, 136, 0));
        jblimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jblimpiar.setText("Cancelar");
        jblimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jblimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 130, -1));

        jbsalir.setBackground(new java.awt.Color(204, 0, 0));
        jbsalir.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbsalir.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 70, 30));

        txtid.setEditable(false);
        txtid.setName("id"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jtJustificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtJustificacionMouseClicked
        int rowSelect = this.jtJustificacion.getSelectedRow();
        this.txtid.setText(this.jtJustificacion.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.jtJustificacion.getValueAt(rowSelect, 1).toString());
        this.cbestado.setSelected(this.jtJustificacion.getValueAt(rowSelect, 2).toString() == "Activo" ? true : false);
    }//GEN-LAST:event_jtJustificacionMouseClicked
    private void crear() {
        this.excepciones.add("id");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.justificacionController.crear() != null) {
                JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                ProjectUtils.limpiarComponentes(this.jPanel1);
                this.mostrarTabla("");
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.justificacionController.actualizar() != null) {
                JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.mostrarTabla("");
                ProjectUtils.limpiarComponentes(this.jPanel1);
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void jbingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbingresarActionPerformed
        this.justificacionController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.justificacionController.getSelected().setNombre(this.txtnombre.getText());
        this.justificacionController.getSelected().setEstado(this.cbestado.isSelected());
        if (this.justificacionController.getSelected().getId() == null) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_jbingresarActionPerformed

    private void jblimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblimpiarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }//GEN-LAST:event_jblimpiarActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbsalirActionPerformed

    private void mostrarTabla(String nombre) {
        this.justificacionController.llenarTabla(this.jtJustificacion, nombre);
    }

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
            java.util.logging.Logger.getLogger(FrmJustificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJustificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJustificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJustificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJustificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbingresar;
    private javax.swing.JButton jblimpiar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JTable jtJustificacion;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
