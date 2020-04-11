/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.SacerdoteController;
import com.iglesia.entities.Usuario;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class DlgSacerdote extends javax.swing.JDialog {

    private Usuario usuarioLogeado;

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    /**
     * Creates new form DlgSacerdote
     */
    private javax.swing.JFormattedTextField txtdui;
    private javax.swing.JFormattedTextField txtnit;
    private SacerdoteController sacerdoteController;
    private List<String> excepciones = new ArrayList<>();

    public DlgSacerdote(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sacerdoteController = new SacerdoteController();
        // comienza generacion de campos formateados
        txtdui = ProjectUtils.getCampoDui();
        txtdui.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtdui.setBorder(null);
        jPanel1.add(txtdui, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 90, -1));

        txtnit = ProjectUtils.getCampoNit();
        txtnit.setFont(new java.awt.Font("Tahoma", 0, 14));// NOI18N
        txtnit.setBorder(null);
        jPanel1.add(txtnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 142, -1));
        // termina generacion de campos formateados
        this.txtid.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mostrarTabla("");
        this.excepciones.add("buscar");
        this.txtnombre.requestFocus();
        new TextPrompt("Digite nombre para buscar", this.txtbuscar);
        this.cbestado.setSelected(true);
        this.cbParroco.setSelected(true);
    }

    private void mostrarTabla(String filtro) {
        this.sacerdoteController.llenarTabla(tbsacerdote, filtro);
    }

    private void crear() {
        this.excepciones.add("id");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            DlgWindow.showMessageDialog(this, "Error", "Campo(s) Requerido(s) vacio(s)", DlgWindow.ERROR);
            return;
        }
        if (this.sacerdoteController.crear() == null) {
            DlgWindow.showMessageDialog(this, "Error", "Ocurrio un problema.!", DlgWindow.ERROR);
            return;
        }
        DlgWindow.showMessageDialog(this, "Aviso", "Registro guardado correctamente");
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }

    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            DlgWindow.showMessageDialog(this, "Error", "Campo(s) Requerido(s) vacio(s)", DlgWindow.ERROR);
            return;
        }
        if (this.sacerdoteController.actualizar() == null) {
            DlgWindow.showMessageDialog(this, "Error", "Ocurrio un problema.!", DlgWindow.ERROR);
            return;
        }
        DlgWindow.showMessageDialog(this, "Aviso", "Registro modificado correctamente");
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbestado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsacerdote = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbParroco = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jPanelTop = new javax.swing.JPanel();
        jbCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 105, 290, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 121, 310, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 310, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 225, 90, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 275, 142, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        txtnombre.setBorder(null);
        txtnombre.setName("Nombre"); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 310, 24));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        txtapellido.setBackground(new java.awt.Color(255, 255, 255));
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtapellido.setForeground(new java.awt.Color(0, 0, 0));
        txtapellido.setBorder(null);
        txtapellido.setName("Apellido"); // NOI18N
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 310, 24));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Parroco");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, -1, -1));

        cbestado.setBackground(new java.awt.Color(255, 255, 255));
        cbestado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbestado.setForeground(new java.awt.Color(0, 0, 0));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 129, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save-w-24px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(254, 192, 1));
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 400, 130, 40));

        txtbuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtbuscar.setBorder(null);
        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, 24));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 51));

        tbsacerdote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbsacerdote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Dui", "Nit", "Parroco", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbsacerdote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbsacerdote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbsacerdoteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbsacerdote);
        if (tbsacerdote.getColumnModel().getColumnCount() > 0) {
            tbsacerdote.getColumnModel().getColumn(0).setMinWidth(30);
            tbsacerdote.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbsacerdote.getColumnModel().getColumn(0).setMaxWidth(45);
            tbsacerdote.getColumnModel().getColumn(3).setMinWidth(80);
            tbsacerdote.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbsacerdote.getColumnModel().getColumn(3).setMaxWidth(80);
            tbsacerdote.getColumnModel().getColumn(4).setMinWidth(125);
            tbsacerdote.getColumnModel().getColumn(4).setPreferredWidth(125);
            tbsacerdote.getColumnModel().getColumn(4).setMaxWidth(125);
            tbsacerdote.getColumnModel().getColumn(5).setMinWidth(55);
            tbsacerdote.getColumnModel().getColumn(5).setPreferredWidth(55);
            tbsacerdote.getColumnModel().getColumn(5).setMaxWidth(55);
            tbsacerdote.getColumnModel().getColumn(6).setMinWidth(51);
            tbsacerdote.getColumnModel().getColumn(6).setPreferredWidth(51);
            tbsacerdote.getColumnModel().getColumn(6).setMaxWidth(51);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 550, 320));

        txtid.setEditable(false);
        txtid.setName("id"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dui");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nit");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        cbParroco.setBackground(new java.awt.Color(255, 255, 255));
        cbParroco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbParroco.setForeground(new java.awt.Color(0, 0, 0));
        cbParroco.setText("Es Parroco");
        jPanel1.add(cbParroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar-b-24px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanelTop.setBackground(new java.awt.Color(0, 129, 255));
        jPanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbCerrar.setBackground(new java.awt.Color(0, 129, 255));
        jbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbCerrar.setBorder(null);
        jbCerrar.setBorderPainted(false);
        jbCerrar.setContentAreaFilled(false);
        jbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanelTop.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 30, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mantenimiento de Sacerdotes");
        jPanelTop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, -1));

        jPanel1.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.sacerdoteController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.sacerdoteController.getSelected().setNombres(this.txtnombre.getText());
        this.sacerdoteController.getSelected().setApellidos(this.txtapellido.getText());
        this.sacerdoteController.getSelected().setDui(this.txtdui.getText());
        this.sacerdoteController.getSelected().setNit(this.txtnit.getText());
        this.sacerdoteController.getSelected().setParroco(this.cbParroco.isSelected());
        this.sacerdoteController.getSelected().setEstado(this.cbestado.isSelected());
        this.sacerdoteController.getSelected().setIdUsuario(this.usuarioLogeado);
        if (this.sacerdoteController.getSelected().getId() == null) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(this.txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tbsacerdoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbsacerdoteMouseClicked
        int rowSelect = this.tbsacerdote.getSelectedRow();
        this.txtid.setText(this.tbsacerdote.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.tbsacerdote.getValueAt(rowSelect, 1).toString());
        this.txtapellido.setText(this.tbsacerdote.getValueAt(rowSelect, 2).toString());
        this.txtdui.setText(this.tbsacerdote.getValueAt(rowSelect, 3).toString());
        this.txtnit.setText(this.tbsacerdote.getValueAt(rowSelect, 4).toString());
        this.cbParroco.setSelected(this.tbsacerdote.getValueAt(rowSelect, 5).toString() == "Parroco" ? true : false);
        this.cbestado.setSelected(this.tbsacerdote.getValueAt(rowSelect, 6).toString() == "Activo" ? true : false);
    }//GEN-LAST:event_tbsacerdoteMouseClicked

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

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
        this.jbCerrar.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_jbCerrarMouseMoved

    private void jbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarMouseExited
        this.jbCerrar.setBackground(new java.awt.Color(0,129,255));
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
            java.util.logging.Logger.getLogger(DlgSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgSacerdote dialog = new DlgSacerdote(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox cbParroco;
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JTable tbsacerdote;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
