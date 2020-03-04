/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.TipoEventoController;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class FrmTipoEvento extends javax.swing.JFrame {

    /**
     * Creates new form FrmTipoEvento
     */
    private TipoEventoController tipoEventoController;
    private List<String> excepciones = new ArrayList<>();
    
    public FrmTipoEvento() {        
        initComponents();
        this.tipoEventoController = new TipoEventoController();
        this.txtid.setVisible(false);        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarTabla("");
        this.excepciones.add("buscar");
        this.txtnombre.requestFocus();
        new TextPrompt("Digite nombre para buscar", this.txtbuscar);
        this.cbestado.setSelected(true);
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
        txtid = new javax.swing.JTextField();
        jbsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbestado = new javax.swing.JCheckBox();
        jbingresar = new javax.swing.JButton();
        jblimpiar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTipoEvento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(380, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(158, 158, 158));
        jPanel1.setMinimumSize(new java.awt.Dimension(380, 490));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtid.setEditable(false);
        txtid.setName("id"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, -1));

        jbsalir.setBackground(new java.awt.Color(204, 0, 0));
        jbsalir.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbsalir.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 70, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento Tipo de Evento");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 350, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Estado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        cbestado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbestado.setForeground(new java.awt.Color(0, 0, 0));
        cbestado.setText("Activo");
        cbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbestadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, -1));

        jbingresar.setBackground(new java.awt.Color(13, 71, 161));
        jbingresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbingresar.setForeground(new java.awt.Color(255, 255, 255));
        jbingresar.setText("Guardar");
        jbingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbingresarActionPerformed(evt);
            }
        });
        jPanel1.add(jbingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, -1));

        jblimpiar.setBackground(new java.awt.Color(255, 136, 0));
        jblimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jblimpiar.setText("Cancelar");
        jblimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jblimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 130, -1));

        txtbuscar.setToolTipText("");
        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 350, -1));

        jtTipoEvento.setBackground(new java.awt.Color(224, 224, 224));
        jtTipoEvento.setForeground(new java.awt.Color(0, 0, 0));
        jtTipoEvento.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTipoEvento.setSelectionBackground(new java.awt.Color(189, 189, 189));
        jtTipoEvento.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtTipoEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTipoEventoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTipoEvento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 350, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbsalirActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void cbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbestadoActionPerformed

    private void mostrarTabla(String nombre) {
        this.tipoEventoController.llenarTabla(this.jtTipoEvento, nombre);
    }
    private void crear() {
        this.excepciones.add("id");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.tipoEventoController.crear() == null) {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }

    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.tipoEventoController.actualizar() == null) {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.mostrarTabla("");
        ProjectUtils.limpiarComponentes(this.jPanel1);
    }
    private void jbingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbingresarActionPerformed
        this.tipoEventoController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.tipoEventoController.getSelected().setNombre(this.txtnombre.getText());
        this.tipoEventoController.getSelected().setEstado(this.cbestado.isSelected());
        if (this.tipoEventoController.getSelected().getId() == null) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_jbingresarActionPerformed

    private void jblimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblimpiarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }//GEN-LAST:event_jblimpiarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jtTipoEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTipoEventoMouseClicked
        int rowSelect = this.jtTipoEvento.getSelectedRow();
        this.txtid.setText(this.jtTipoEvento.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.jtTipoEvento.getValueAt(rowSelect, 1).toString());
        this.cbestado.setSelected(this.jtTipoEvento.getValueAt(rowSelect, 2).toString() == "Activo" ? true : false);
    }//GEN-LAST:event_jtTipoEventoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmTipoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTipoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTipoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTipoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTipoEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbingresar;
    private javax.swing.JButton jblimpiar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JTable jtTipoEvento;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}