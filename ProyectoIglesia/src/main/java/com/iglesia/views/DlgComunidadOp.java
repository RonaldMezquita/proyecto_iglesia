/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.ComunidadController;
import com.iglesia.controllers.SectorController;
import com.iglesia.entities.Sector;
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
public class DlgComunidadOp extends javax.swing.JDialog {

    /**
     * Creates new form DlgComunidad
     */
    private ComunidadController comunidadController;
    private List<String> excepciones = new ArrayList<>();
    private SectorController sectorController;

    public DlgComunidadOp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.comunidadController = new ComunidadController();
        this.sectorController = new SectorController();
        this.txtid.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarTabla("");
        this.excepciones.add("buscar");
        this.txtbuscar.requestFocus();
        new TextPrompt("Digite nombre para buscar", this.txtbuscar);
        this.cbestado.setSelected(true);
        this.llenarCombo();
        this.jpConsulta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        ProjectUtils.setUnderline(this.jlblConsultar);
    }
   
    private void mostrarTabla(String nombre) {
        this.comunidadController.llenarTabla(this.jtComunidad, nombre);
    }

    private void llenarCombo() {
        this.sectorController.getCombobox(jbcSector);
    }

    private void showNuevo() {
        if (this.jpConsulta.getX() == 0) {
            this.txtnombre.requestFocus();
            Animacion.Animacion.mover_izquierda(0, -440, 10, 10, this.jpConsulta);
            Animacion.Animacion.mover_izquierda(440, 0, 10, 10, this.jpNuevo);
        }
    }

    private void showConsulta() {
        if (this.jpNuevo.getX() == 0) {
            this.txtbuscar.requestFocus();
            Animacion.Animacion.mover_derecha(-440, 0, 10, 10, this.jpConsulta);
            Animacion.Animacion.mover_derecha(0, 440, 10, 10, this.jpNuevo);
        }
    }

    private void cerrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Confirmación", dialog);
        if (result == 0) {
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void crear() {
        this.excepciones.add("id");
        if (ProjectUtils.validarVacios(this.jpConsulta, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.comunidadController.crear() == null) {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        ProjectUtils.limpiarComponentes(this.jpConsulta);
        this.mostrarTabla("");
        this.showConsulta();
    }

    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jpConsulta, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.comunidadController.actualizar() == null) {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema.!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        this.mostrarTabla("");
        ProjectUtils.limpiarComponentes(this.jpConsulta);
        this.showConsulta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpConsulta = new javax.swing.JPanel();
        jbsalir = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComunidad = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jpNuevo = new javax.swing.JPanel();
        jbsalir1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbcSector = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbestado = new javax.swing.JCheckBox();
        jbingresar = new javax.swing.JButton();
        jblimpiar = new javax.swing.JButton();
        jlblConsultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(440, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpConsulta.setBackground(new java.awt.Color(55, 71, 79));
        jpConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbsalir.setBackground(new java.awt.Color(204, 0, 0));
        jbsalir.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbsalir.setBorder(null);
        jbsalir.setBorderPainted(false);
        jbsalir.setContentAreaFilled(false);
        jbsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir.setOpaque(true);
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jpConsulta.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 1, 30, 30));

        txtbuscar.setBackground(new java.awt.Color(55, 71, 79));
        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtbuscar.setToolTipText("");
        txtbuscar.setBorder(null);
        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jpConsulta.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, 30));

        jtComunidad.setBackground(new java.awt.Color(224, 224, 224));
        jtComunidad.setForeground(new java.awt.Color(0, 0, 0));
        jtComunidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Sector", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jtComunidad.setSelectionBackground(new java.awt.Color(189, 189, 189));
        jtComunidad.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtComunidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtComunidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtComunidad);
        if (jtComunidad.getColumnModel().getColumnCount() > 0) {
            jtComunidad.getColumnModel().getColumn(0).setMinWidth(30);
            jtComunidad.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtComunidad.getColumnModel().getColumn(0).setMaxWidth(45);
            jtComunidad.getColumnModel().getColumn(3).setMinWidth(60);
            jtComunidad.getColumnModel().getColumn(3).setPreferredWidth(60);
            jtComunidad.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        jpConsulta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 420, 180));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        jLabel5.setToolTipText("");
        jpConsulta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jpConsulta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 230, -1));

        btnNuevo.setBackground(new java.awt.Color(0, 153, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/agregar.png"))); // NOI18N
        btnNuevo.setText("Nueva Comunidad");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setOpaque(true);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jpConsulta.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 125, 150, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Consulta de Comunidades");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpConsulta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 440, -1));

        getContentPane().add(jpConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 380));

        jpNuevo.setBackground(new java.awt.Color(55, 71, 79));
        jpNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbsalir1.setBackground(new java.awt.Color(204, 0, 0));
        jbsalir1.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbsalir1.setBorder(null);
        jbsalir1.setBorderPainted(false);
        jbsalir1.setContentAreaFilled(false);
        jbsalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir1.setOpaque(true);
        jbsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalir1ActionPerformed(evt);
            }
        });
        jpNuevo.add(jbsalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 1, 30, 30));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jpNuevo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 320, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Comunidad");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpNuevo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 440, -1));

        txtid.setEditable(false);
        txtid.setName("id"); // NOI18N
        jpNuevo.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        jpNuevo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtnombre.setBackground(new java.awt.Color(55, 71, 79));
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setBorder(null);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jpNuevo.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 320, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sector");
        jpNuevo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jbcSector.setBackground(new java.awt.Color(55, 71, 79));
        jbcSector.setEditable(true);
        jbcSector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbcSector.setForeground(new java.awt.Color(255, 255, 255));
        jbcSector.setBorder(null);
        jpNuevo.add(jbcSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 320, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado");
        jpNuevo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        cbestado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbestado.setForeground(new java.awt.Color(255, 255, 255));
        cbestado.setText("Activo");
        cbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbestadoActionPerformed(evt);
            }
        });
        jpNuevo.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 90, -1));

        jbingresar.setBackground(new java.awt.Color(13, 71, 161));
        jbingresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbingresar.setForeground(new java.awt.Color(255, 255, 255));
        jbingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save.png"))); // NOI18N
        jbingresar.setText("Guardar");
        jbingresar.setBorder(null);
        jbingresar.setBorderPainted(false);
        jbingresar.setContentAreaFilled(false);
        jbingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbingresar.setOpaque(true);
        jbingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbingresarActionPerformed(evt);
            }
        });
        jpNuevo.add(jbingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, 40));

        jblimpiar.setBackground(new java.awt.Color(255, 136, 0));
        jblimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jblimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jblimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        jblimpiar.setText("Cancelar");
        jblimpiar.setBorder(null);
        jblimpiar.setBorderPainted(false);
        jblimpiar.setContentAreaFilled(false);
        jblimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblimpiar.setOpaque(true);
        jblimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblimpiarActionPerformed(evt);
            }
        });
        jpNuevo.add(jblimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 290, 130, 40));

        jlblConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblConsultar.setForeground(new java.awt.Color(255, 255, 255));
        jlblConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultar.setText("Consultar Registros");
        jlblConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblConsultarMouseClicked(evt);
            }
        });
        jpNuevo.add(jlblConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, -1));

        getContentPane().add(jpNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 440, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.cerrar();
    }//GEN-LAST:event_jbsalirActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void cbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbestadoActionPerformed

    private void jbingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbingresarActionPerformed
        this.comunidadController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.comunidadController.getSelected().setNombre(this.txtnombre.getText());
        this.comunidadController.getSelected().setEstado(this.cbestado.isSelected());
        if (((Sector) this.jbcSector.getSelectedItem()).getId() == null) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.comunidadController.getSelected().setIdSector((Sector) this.jbcSector.getSelectedItem());
        //        this.comunidadController.getSelected().setIdSector(((Sector) this.jbcSector.getSelectedItem()).getId() != null ? this.jbcSector.getSelectedItem() : null);
        if (this.comunidadController.getSelected().getId() == null) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_jbingresarActionPerformed

    private void jblimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblimpiarActionPerformed
        ProjectUtils.limpiarComponentes(this.jpNuevo);
        this.mostrarTabla("");
    }//GEN-LAST:event_jblimpiarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jtComunidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComunidadMouseClicked
        int rowSelect = this.jtComunidad.getSelectedRow();
        this.txtid.setText(this.jtComunidad.getValueAt(rowSelect, 0).toString());
        this.txtnombre.setText(this.jtComunidad.getValueAt(rowSelect, 1).toString());
        this.jbcSector.setSelectedItem(this.jtComunidad.getValueAt(rowSelect, 2));
        this.cbestado.setSelected(this.jtComunidad.getValueAt(rowSelect, 3).toString() == "Activo" ? true : false);
        this.showNuevo();
    }//GEN-LAST:event_jtComunidadMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ProjectUtils.limpiarComponentes(this.jpNuevo);
        this.showNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jlblConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblConsultarMouseClicked
        this.showConsulta();
    }//GEN-LAST:event_jlblConsultarMouseClicked

    private void jbsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalir1ActionPerformed
        this.cerrar();
    }//GEN-LAST:event_jbsalir1ActionPerformed

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
            java.util.logging.Logger.getLogger(DlgComunidadOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgComunidadOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgComunidadOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgComunidadOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgComunidadOp dialog = new DlgComunidadOp(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<Sector> jbcSector;
    private javax.swing.JButton jbingresar;
    private javax.swing.JButton jblimpiar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JButton jbsalir1;
    private javax.swing.JLabel jlblConsultar;
    private javax.swing.JPanel jpConsulta;
    private javax.swing.JPanel jpNuevo;
    private javax.swing.JTable jtComunidad;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
