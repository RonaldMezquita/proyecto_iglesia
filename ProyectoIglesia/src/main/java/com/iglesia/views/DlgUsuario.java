/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.UsuarioController;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class DlgUsuario extends javax.swing.JDialog {

    /**
     * Creates new form DlgUsuario
     */
    private UsuarioController usuarioController;
    private List<String> excepciones = new ArrayList<>();

    public DlgUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.usuarioController = new UsuarioController();
        this.txtid.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mostrarTabla("");
        this.excepciones.add("buscar");
        this.txtnombre.requestFocus();
        new TextPrompt("Digite nombre para buscar", this.txtbuscar);
        this.cbestado.setSelected(true);
    }

    DlgUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarTabla(String filtro) {
        this.usuarioController.llenarTabla(tbusuario, filtro);
    }

    private void crear() {
        this.excepciones.add("idUsuario");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.usuarioController.crear() == null) {
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
        if (this.usuarioController.actualizar() == null) {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.mostrarTabla("");
        ProjectUtils.limpiarComponentes(this.jPanel1);
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
        jLabel1 = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuario = new javax.swing.JTable();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbestado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtid.setEditable(false);
        txtid.setName("idUsuario"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingreso de Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jbCerrar.setBackground(new java.awt.Color(222, 62, 68));
        jbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbCerrar.setToolTipText("");
        jbCerrar.setBorder(null);
        jbCerrar.setBorderPainted(false);
        jbCerrar.setContentAreaFilled(false);
        jbCerrar.setOpaque(true);
        jbCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbCerrarMouseMoved(evt);
            }
        });
        jbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbCerrarMouseExited(evt);
            }
        });
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 1, 30, 30));

        txtbuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 290, -1));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 51));

        tbusuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Usuario", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbusuario.setToolTipText("");
        tbusuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbusuario);
        if (tbusuario.getColumnModel().getColumnCount() > 0) {
            tbusuario.getColumnModel().getColumn(0).setMinWidth(30);
            tbusuario.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbusuario.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 460, 240));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnombre.setName("Nombre"); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 310, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        txtapellido.setBackground(new java.awt.Color(255, 255, 255));
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtapellido.setName("Apellido"); // NOI18N
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 310, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 310, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        cbestado.setBackground(new java.awt.Color(255, 255, 255));
        cbestado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbestado.setForeground(new java.awt.Color(0, 0, 0));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 129, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnGuardarMouseMoved(evt);
            }
        });
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(254, 192, 1));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCancelarMouseMoved(evt);
            }
        });
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(this.txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tbusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusuarioMouseClicked
        int rowSelect = this.tbusuario.getSelectedRow();
        this.txtid.setText(this.tbusuario.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.tbusuario.getValueAt(rowSelect, 1).toString());
        this.txtapellido.setText(this.tbusuario.getValueAt(rowSelect, 2).toString());
        this.txtusuario.setText(this.tbusuario.getValueAt(rowSelect, 3).toString());
        this.cbestado.setSelected(this.tbusuario.getValueAt(rowSelect, 4).toString() == "Activo" ? true : false);
    }//GEN-LAST:event_tbusuarioMouseClicked

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.usuarioController.getSelected().setIdUsuario((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.usuarioController.getSelected().setNombre(this.txtnombre.getText());
        this.usuarioController.getSelected().setApellido(this.txtapellido.getText());
        this.usuarioController.getSelected().setUsuario(this.txtusuario.getText());
        this.usuarioController.getSelected().setEstado(this.cbestado.isSelected());
        if (this.usuarioController.getSelected().getIdUsuario() == null) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseMoved
        this.btnGuardar.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_btnGuardarMouseMoved

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        this.btnGuardar.setBackground(new java.awt.Color(0, 129, 255));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnCancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseMoved
        this.btnCancelar.setBackground(new java.awt.Color(254, 203, 46));
    }//GEN-LAST:event_btnCancelarMouseMoved

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        this.btnCancelar.setBackground(new java.awt.Color(254, 192, 1));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void jbCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarMouseMoved
        this.jbCerrar.setBackground(new java.awt.Color(227, 96, 101));
    }//GEN-LAST:event_jbCerrarMouseMoved

    private void jbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarMouseExited
        this.jbCerrar.setBackground(new java.awt.Color(222, 62, 68));
    }//GEN-LAST:event_jbCerrarMouseExited

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
            java.util.logging.Logger.getLogger(DlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgUsuario dialog = new DlgUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JTable tbusuario;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
