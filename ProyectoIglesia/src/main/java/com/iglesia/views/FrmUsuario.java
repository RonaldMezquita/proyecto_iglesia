/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.UsuarioController;
import com.iglesia.utils.ProjectUtils;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alexi
 */
public class FrmUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuario
     */
    private UsuarioController usuarioController;
    private List<String> excepciones = new ArrayList<>();
    
    public FrmUsuario() {
        initComponents();
        this.usuarioController = new UsuarioController();
        this.setTitle("Usuario");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mostrarTabla();
        this.excepciones.add("idUsuario");
        this.txtnombre.requestFocus();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtclave = new javax.swing.JTextField();
        cbestado = new javax.swing.JCheckBox();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuario = new javax.swing.JTable();
        btncancelar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        lbfondo = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso de Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Clave:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        txtnombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtnombre.setName("Nombre"); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 240, -1));

        txtapellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtapellido.setName("Apellido"); // NOI18N
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 240, -1));

        txtusuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 240, -1));

        txtclave.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 240, -1));

        cbestado.setForeground(new java.awt.Color(255, 255, 255));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        btnguardar.setBackground(new java.awt.Color(0, 0, 51));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Ingresar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        btnmodificar.setBackground(new java.awt.Color(0, 0, 51));
        btnmodificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnmodificar.setForeground(new java.awt.Color(255, 255, 255));
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 51));

        tbusuario.setBackground(new java.awt.Color(0, 0, 51));
        tbusuario.setForeground(new java.awt.Color(255, 255, 255));
        tbusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbusuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 460, 280));

        btncancelar.setBackground(new java.awt.Color(0, 0, 51));
        btncancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, -1, -1));

        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/boton-salir.png"))); // NOI18N
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 30, 30));

        lbfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Fondo.jpg"))); // NOI18N
        jPanel1.add(lbfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 880, 370));

        txtid.setEditable(false);
        txtid.setName("idUsuario"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclaveActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.usuarioController.getSelected().setNombre(this.txtnombre.getText());
            this.usuarioController.getSelected().setApellido(this.txtapellido.getText());
            this.usuarioController.getSelected().setUsuario(this.txtusuario.getText());
            this.usuarioController.getSelected().setClave(this.txtclave.getText());
            this.usuarioController.getSelected().setEstado(this.cbestado.isSelected());
            
            if (this.usuarioController.crear() != null) {
                JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                ProjectUtils.limpiarComponentes(this.jPanel1);
                this.mostrarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        if (ProjectUtils.validarVacios(this.jPanel1, null)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.usuarioController.getSelected().setIdUsuario(Integer.parseInt(this.txtid.getText()));
            this.usuarioController.getSelected().setNombre(this.txtnombre.getText());
            this.usuarioController.getSelected().setApellido(this.txtapellido.getText());
            this.usuarioController.getSelected().setUsuario(this.txtusuario.getText());
            this.usuarioController.getSelected().setClave(this.txtclave.getText());
            this.usuarioController.getSelected().setEstado(this.cbestado.isSelected());
            
            if (this.usuarioController.actualizar() != null) {
                JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.mostrarTabla();
                ProjectUtils.limpiarComponentes(this.jPanel1);
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tbusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusuarioMouseClicked
        int rowSelect = this.tbusuario.getSelectedRow();
        this.txtid.setText(this.tbusuario.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.tbusuario.getValueAt(rowSelect, 1).toString());
        this.txtapellido.setText(this.tbusuario.getValueAt(rowSelect, 2).toString());
        this.txtusuario.setText(this.tbusuario.getValueAt(rowSelect, 3).toString());
        this.cbestado.setSelected(this.tbusuario.getValueAt(rowSelect, 4).toString() == "Activo" ? true : false);
    }//GEN-LAST:event_tbusuarioMouseClicked

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbsalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });
    }
    
    private void mostrarTabla() {
        this.usuarioController.llenarTabla(tbusuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbsalir;
    private javax.swing.JLabel lbfondo;
    private javax.swing.JTable tbusuario;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtclave;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
