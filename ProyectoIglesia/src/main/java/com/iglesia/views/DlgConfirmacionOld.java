/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.ConfirmacionController;
import com.iglesia.controllers.EventoController;
import com.iglesia.utils.ProjectUtils;
import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author remsf
 */
public class DlgConfirmacionOld extends javax.swing.JDialog {

    private final EventoController eventoCtrl;

    /**
     * Creates new form DlgConfirmacion
     */
    public DlgConfirmacionOld(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.eventoCtrl = new EventoController();
        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.txtTomo.requestFocus();
    }

    private void setOrderTab() {

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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTomo = new javax.swing.JTextField();
        txtFolio = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtLugar = new javax.swing.JTextField();
        btnBuscarLugar = new javax.swing.JButton();
        txtSacramentado = new javax.swing.JTextField();
        btnBuscarSacramentado = new javax.swing.JButton();
        txtPadre = new javax.swing.JTextField();
        btnBuscarPadre = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtMadre = new javax.swing.JTextField();
        btnBuscarMadre = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtPadrino = new javax.swing.JTextField();
        btnBuscarPadrino = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSacerdote = new javax.swing.JTextField();
        btnBuscarSacerdote = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtMadrina = new javax.swing.JTextField();
        btnBuscarMadrina = new javax.swing.JButton();
        btnEliminarPadre = new javax.swing.JButton();
        btnEliminarPadrino = new javax.swing.JButton();
        btnEliminarMadre = new javax.swing.JButton();
        btnEliminarMadrina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tomo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Folio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha del evento");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Número");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lugar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sacramentado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Padre");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jbCerrar.setBackground(new java.awt.Color(204, 0, 0));
        jbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 40, 32));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Confirmación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 750, -1));
        jPanel1.add(txtTomo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, -1));
        jPanel1.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 100, -1));
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 130, -1));

        txtLugar.setEditable(false);
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, -1));

        btnBuscarLugar.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarLugar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarLugar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarLugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarLugar.setText("Buscar");
        btnBuscarLugar.setToolTipText("Buscar novio");
        btnBuscarLugar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLugarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 30));

        txtSacramentado.setEditable(false);
        jPanel1.add(txtSacramentado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 200, -1));

        btnBuscarSacramentado.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarSacramentado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarSacramentado.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarSacramentado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarSacramentado.setText("Buscar");
        btnBuscarSacramentado.setToolTipText("Buscar novio");
        btnBuscarSacramentado.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarSacramentado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSacramentadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarSacramentado, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 110, 30));

        txtPadre.setEditable(false);
        jPanel1.add(txtPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 200, -1));

        btnBuscarPadre.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarPadre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarPadre.setText("Buscar");
        btnBuscarPadre.setToolTipText("Buscar padre de novio");
        btnBuscarPadre.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPadreActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 110, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Madre");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        txtMadre.setEditable(false);
        jPanel1.add(txtMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 200, -1));

        btnBuscarMadre.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarMadre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarMadre.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarMadre.setText("Buscar");
        btnBuscarMadre.setToolTipText("Buscar madre de novio");
        btnBuscarMadre.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMadreActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 110, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Padrino");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtPadrino.setEditable(false);
        jPanel1.add(txtPadrino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, -1));

        btnBuscarPadrino.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarPadrino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarPadrino.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPadrino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarPadrino.setText("Buscar");
        btnBuscarPadrino.setToolTipText("Buscar madre de novia");
        btnBuscarPadrino.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPadrinoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarPadrino, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 110, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sacerdote");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        txtSacerdote.setEditable(false);
        jPanel1.add(txtSacerdote, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 200, -1));

        btnBuscarSacerdote.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarSacerdote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarSacerdote.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarSacerdote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarSacerdote.setText("Buscar");
        btnBuscarSacerdote.setToolTipText("Buscar madre de novia");
        btnBuscarSacerdote.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarSacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSacerdoteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarSacerdote, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 110, 30));

        btnGuardar.setBackground(new java.awt.Color(13, 71, 161));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 130, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 136, 0));
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 130, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Madrina");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        txtMadrina.setEditable(false);
        jPanel1.add(txtMadrina, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 200, -1));

        btnBuscarMadrina.setBackground(new java.awt.Color(0, 126, 51));
        btnBuscarMadrina.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarMadrina.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarMadrina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarMadrina.setText("Buscar");
        btnBuscarMadrina.setToolTipText("Buscar madre de novia");
        btnBuscarMadrina.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarMadrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMadrinaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarMadrina, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 110, 30));

        btnEliminarPadre.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarPadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/delete.png"))); // NOI18N
        btnEliminarPadre.setToolTipText("Quitar Padre");
        btnEliminarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPadreActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 30, 30));

        btnEliminarPadrino.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarPadrino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/delete.png"))); // NOI18N
        btnEliminarPadrino.setToolTipText("Quitar Padrino");
        btnEliminarPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPadrinoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarPadrino, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 30, 30));

        btnEliminarMadre.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/delete.png"))); // NOI18N
        btnEliminarMadre.setToolTipText("Quitar Madre");
        btnEliminarMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMadreActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 30, 30));

        btnEliminarMadrina.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarMadrina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/delete.png"))); // NOI18N
        btnEliminarMadrina.setToolTipText("Quitar Madrina");
        btnEliminarMadrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMadrinaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarMadrina, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void btnBuscarLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLugarActionPerformed
        DlgBuscarLugar obj = new DlgBuscarLugar(this, true);
        obj.setVisible(true);
        if (obj.getLugar() != null) {
            this.eventoCtrl.getDtoSelected().setLugar(obj.getLugar());
            this.txtLugar.setText(this.eventoCtrl.getDtoSelected().getLugar().getNombre());
        }
    }//GEN-LAST:event_btnBuscarLugarActionPerformed

    private void btnBuscarSacramentadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSacramentadoActionPerformed
        DlgBuscarPersona obj = new DlgBuscarPersona(this, true);
        obj.setVisible(true);
        if (obj.getPersona() != null) {
            this.eventoCtrl.getDtoSelected().setSacramentado(obj.getPersona());
            this.txtSacramentado.setText(this.eventoCtrl.getDtoSelected().getSacramentado().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarSacramentadoActionPerformed

    private void btnBuscarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPadreActionPerformed
        DlgBuscarPersona obj = new DlgBuscarPersona(this, true);
        obj.setVisible(true);
        if (obj.getPersona() != null) {
            this.eventoCtrl.getDtoSelected().setPadreSacramentado(obj.getPersona());
            this.txtPadre.setText(this.eventoCtrl.getDtoSelected().getPadreSacramentado().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarPadreActionPerformed

    private void btnBuscarMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMadreActionPerformed
        DlgBuscarPersona obj = new DlgBuscarPersona(this, true);
        obj.setVisible(true);
        if (obj.getPersona() != null) {
            this.eventoCtrl.getDtoSelected().setMadreSacramentado(obj.getPersona());
            this.txtMadre.setText(this.eventoCtrl.getDtoSelected().getMadreSacramentado().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarMadreActionPerformed

    private void btnBuscarPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPadrinoActionPerformed
        DlgBuscarPersona obj = new DlgBuscarPersona(this, true);
        obj.setVisible(true);
        if (obj.getPersona() != null) {
            this.eventoCtrl.getDtoSelected().setPadrino(obj.getPersona());
            this.txtPadrino.setText(this.eventoCtrl.getDtoSelected().getPadrino().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarPadrinoActionPerformed

    private void btnBuscarSacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSacerdoteActionPerformed
        DlgBuscarSacerdote obj = new DlgBuscarSacerdote(this, true);
        obj.setVisible(true);
        if (obj.getSacerdote() != null) {
            this.eventoCtrl.getDtoSelected().setSacerdote(obj.getSacerdote());
            this.txtSacerdote.setText(this.eventoCtrl.getDtoSelected().getSacerdote().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarSacerdoteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro de realizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
            this.eventoCtrl.getDtoSelected().setTomo(this.txtTomo.getText());
            this.eventoCtrl.getDtoSelected().setFolio(this.txtFolio.getText());
            this.eventoCtrl.getDtoSelected().setNumero(this.txtNumero.getText());
            this.eventoCtrl.getDtoSelected().setFecha(this.txtFecha.getDate());
            this.crear();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void crear() {        
        if (ProjectUtils.validarVacios(this.jPanel1, null)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.eventoCtrl.registrarEvento(new ConfirmacionController())) {
            JOptionPane.showMessageDialog(this, "Registro realizado correctamente.!", "Información", JOptionPane.INFORMATION_MESSAGE);
            ProjectUtils.limpiarComponentes(this.jPanel1);
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el registro.!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnBuscarMadrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMadrinaActionPerformed
        DlgBuscarPersona obj = new DlgBuscarPersona(this, true);
        obj.setVisible(true);
        if (obj.getPersona() != null) {
            this.eventoCtrl.getDtoSelected().setMadrina(obj.getPersona());
            this.txtMadrina.setText(this.eventoCtrl.getDtoSelected().getMadrina().getNombreCompleto());
        }
    }//GEN-LAST:event_btnBuscarMadrinaActionPerformed

    private void btnEliminarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPadreActionPerformed
        this.eventoCtrl.getDtoSelected().setPadreSacramentado(null);
        this.txtPadre.setText("");
    }//GEN-LAST:event_btnEliminarPadreActionPerformed

    private void btnEliminarPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPadrinoActionPerformed
        this.eventoCtrl.getDtoSelected().setPadrino(null);
        this.txtPadrino.setText("");
    }//GEN-LAST:event_btnEliminarPadrinoActionPerformed

    private void btnEliminarMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMadreActionPerformed
        this.eventoCtrl.getDtoSelected().setMadreSacramentado(null);
        this.txtMadre.setText("");
    }//GEN-LAST:event_btnEliminarMadreActionPerformed

    private void btnEliminarMadrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMadrinaActionPerformed
        this.eventoCtrl.getDtoSelected().setMadrina(null);
        this.txtMadrina.setText("");
    }//GEN-LAST:event_btnEliminarMadrinaActionPerformed

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
            java.util.logging.Logger.getLogger(DlgConfirmacionOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConfirmacionOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConfirmacionOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConfirmacionOld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConfirmacionOld dialog = new DlgConfirmacionOld(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscarLugar;
    private javax.swing.JButton btnBuscarMadre;
    private javax.swing.JButton btnBuscarMadrina;
    private javax.swing.JButton btnBuscarPadre;
    private javax.swing.JButton btnBuscarPadrino;
    private javax.swing.JButton btnBuscarSacerdote;
    private javax.swing.JButton btnBuscarSacramentado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarMadre;
    private javax.swing.JButton btnEliminarMadrina;
    private javax.swing.JButton btnEliminarPadre;
    private javax.swing.JButton btnEliminarPadrino;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCerrar;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtMadre;
    private javax.swing.JTextField txtMadrina;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPadre;
    private javax.swing.JTextField txtPadrino;
    private javax.swing.JTextField txtSacerdote;
    private javax.swing.JTextField txtSacramentado;
    private javax.swing.JTextField txtTomo;
    // End of variables declaration//GEN-END:variables
}
