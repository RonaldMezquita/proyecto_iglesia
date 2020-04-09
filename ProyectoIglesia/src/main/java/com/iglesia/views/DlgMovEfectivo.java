/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import FiveCodMover.FiveCodMoverJDialog;
import com.iglesia.controllers.JustificacionController;
import com.iglesia.controllers.MovimientoController;
import com.iglesia.entities.Evento;
import com.iglesia.entities.Justificacion;
import com.iglesia.entities.Movimiento;
import com.iglesia.entities.Usuario;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald Mezquita
 */
public class DlgMovEfectivo extends javax.swing.JDialog {

    private Usuario usuarioLogeado;

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    /**
     * Creates new form DlgMovEfectivo
     */
    private MovimientoController movimientoController;
    private JustificacionController justificacionController;
    private List<String> excepciones = new ArrayList<>();
    private Movimiento selectedMov;
    private boolean redirect;

    public Movimiento getSelectedMov() {
        return selectedMov;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public void setSelectedMov(Movimiento selectedMov) {
        this.selectedMov = selectedMov;
        String s = selectedMov.getIdEvento().getIdTipoSacramento().getNombre() + ", Folio " + selectedMov.getIdEvento().getFolio() + ", número " + selectedMov.getIdEvento().getNumero();
        this.txtEvento.setText(s);
        this.txtid.setText(selectedMov.getId().toString());
        this.jdFechaMov.setDate(selectedMov.getFechaMov());
        this.txtMonto.setText(ProjectUtils.formatearMoneda(selectedMov.getMonto()));
        this.cbTipoMovimiento.setSelectedItem(selectedMov.getTipo());
        this.cbJustificacion.setSelectedItem(selectedMov.getIdJustificacion());
        this.cbestado.setSelected(selectedMov.getEstado());
    }

    public DlgMovEfectivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.movimientoController = new MovimientoController();
        this.justificacionController = new JustificacionController();
        this.txtid.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.excepciones.add("buscar");
        this.txtMonto.requestFocus();
        this.cbestado.setSelected(true);
        this.justificacionController.getComboBox(this.cbJustificacion);
        this.selectedMov = new Movimiento();

        this.movimientoController.getComboTipoMov(this.cbTipoMovimiento);
        this.jdFechaMov.setDate(FechasUtils.getCurrentDate());
    }

    private boolean crear() {
        boolean response = true;
        this.excepciones.add("idUsuario");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            DlgWindow.showMessageDialog(this, "Error", "Campo(s) Requerido(s) vacio(s)", DlgWindow.ERROR);
            response = false;
        }
        this.cargarDatos();
        if (!this.movimientoController.crear()) {
            DlgWindow.showMessageDialog(this, "Error", "Ocurrio un problema.!", DlgWindow.ERROR);
            response = false;
        }
        if (response) {
            DlgWindow.showMessageDialog(this, "Aviso", "Registro guardado correctamente");
            ProjectUtils.limpiarComponentes(this.jPanel1);
        }
        return response;
    }

    private boolean actualizar() {
        boolean response = true;
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            DlgWindow.showMessageDialog(this, "Error", "Campo(s) Requerido(s) vacio(s)", DlgWindow.ERROR);
            response = false;
        }
        this.cargarDatos();
        if (!this.movimientoController.actualizar()) {
            DlgWindow.showMessageDialog(this, "Error", "Ocurrio un problema.!", DlgWindow.ERROR);
            response = false;
        }
        if (response) {
            DlgWindow.showMessageDialog(this, "Aviso", "Registro modificado correctamente",DlgWindow.ERROR);
            ProjectUtils.limpiarComponentes(this.jPanel1);
            if (this.redirect) {
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
        return response;
    }

    private void cargarDatos() {
        this.selectedMov.setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.selectedMov.setFechaMov(this.jdFechaMov.getDate());
        this.selectedMov.setMonto(new BigDecimal(this.txtMonto.getText()));
        this.selectedMov.setTipo(this.cbTipoMovimiento.getSelectedItem().toString());
        this.selectedMov.setIdJustificacion((Justificacion) this.cbJustificacion.getSelectedItem());
        this.selectedMov.setEstado(this.cbestado.isSelected());
        this.selectedMov.setIdUsuario(this.usuarioLogeado);
        this.movimientoController.setSelected(this.selectedMov);
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
        jsMonto = new javax.swing.JSeparator();
        jsEvento = new javax.swing.JSeparator();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEvento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbestado = new javax.swing.JCheckBox();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jdFechaMov = new com.toedter.calendar.JDateChooser();
        cbJustificacion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarEvento = new javax.swing.JButton();
        btnEliminarEvento = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbTipoMovimiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jsMonto.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jsMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 205, 180, -1));

        jsEvento.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jsEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 365, 270, -1));

        txtid.setEditable(false);
        txtid.setName("idUsuario"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 60, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimientos de Efectivo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, -1));

        jbsalir.setBackground(new java.awt.Color(222, 62, 68));
        jbsalir.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbsalir.setBorder(null);
        jbsalir.setBorderPainted(false);
        jbsalir.setContentAreaFilled(false);
        jbsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir.setOpaque(true);
        jbsalir.setRequestFocusEnabled(false);
        jbsalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbsalirMouseMoved(evt);
            }
        });
        jbsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbsalirMouseExited(evt);
            }
        });
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 1, 30, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Evento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Monto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        txtMonto.setBackground(new java.awt.Color(255, 255, 255));
        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(0, 0, 0));
        txtMonto.setBorder(null);
        txtMonto.setName("Apellido"); // NOI18N
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo movimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtEvento.setEditable(false);
        txtEvento.setBackground(new java.awt.Color(255, 255, 255));
        txtEvento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEvento.setForeground(new java.awt.Color(0, 0, 0));
        txtEvento.setBorder(null);
        jPanel1.add(txtEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 270, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        cbestado.setBackground(new java.awt.Color(255, 255, 255));
        cbestado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbestado.setForeground(new java.awt.Color(0, 0, 0));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        btnguardar.setBackground(new java.awt.Color(0, 129, 255));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setBorder(null);
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setOpaque(true);
        btnguardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnguardarMouseMoved(evt);
            }
        });
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnguardarMouseExited(evt);
            }
        });
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 130, 40));

        btncancelar.setBackground(new java.awt.Color(254, 192, 1));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.setOpaque(true);
        btncancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btncancelarMouseMoved(evt);
            }
        });
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncancelarMouseExited(evt);
            }
        });
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 130, 40));

        jdFechaMov.setBackground(new java.awt.Color(255, 255, 255));
        jdFechaMov.setForeground(new java.awt.Color(55, 71, 79));
        jdFechaMov.setDateFormatString("dd/MM/yyyy");
        jdFechaMov.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jdFechaMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 150, 30));

        cbJustificacion.setBackground(new java.awt.Color(255, 255, 255));
        cbJustificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbJustificacion.setBorder(null);
        jPanel1.add(cbJustificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 270, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        btnBuscarEvento.setBackground(new java.awt.Color(107, 117, 125));
        btnBuscarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar.png"))); // NOI18N
        btnBuscarEvento.setToolTipText("Buscar evento");
        btnBuscarEvento.setBorder(null);
        btnBuscarEvento.setBorderPainted(false);
        btnBuscarEvento.setContentAreaFilled(false);
        btnBuscarEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEvento.setOpaque(true);
        btnBuscarEvento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBuscarEventoMouseMoved(evt);
            }
        });
        btnBuscarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarEventoMouseExited(evt);
            }
        });
        btnBuscarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEventoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 340, 30, 30));

        btnEliminarEvento.setBackground(new java.awt.Color(222, 62, 68));
        btnEliminarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/delete.png"))); // NOI18N
        btnEliminarEvento.setToolTipText("Quitar Evento");
        btnEliminarEvento.setBorder(null);
        btnEliminarEvento.setBorderPainted(false);
        btnEliminarEvento.setContentAreaFilled(false);
        btnEliminarEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEvento.setOpaque(true);
        btnEliminarEvento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEliminarEventoMouseMoved(evt);
            }
        });
        btnEliminarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEventoMouseExited(evt);
            }
        });
        btnEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEventoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 30, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Justificación");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        cbTipoMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        cbTipoMovimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipoMovimiento.setBorder(null);
        jPanel1.add(cbTipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 270, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(132, 142, 149));
        jLabel8.setText("(Opcional)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 323, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
//        if (DlgWindow.showConfirmDialog(this, "Confirmación", "¿Desea salir de esta opción?") == 0) {
//        }
    }//GEN-LAST:event_jbsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (this.txtid.getText().trim().equals("")) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
//            JOptionPane.showMessageDialog(this, "Solo numeros");
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void btnBuscarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEventoActionPerformed
        DlgBuscarEvento obj = new DlgBuscarEvento(this, true);
        obj.setVisible(true);
        if (obj.getEvento() != null) {
            Evento evento = obj.getEvento();
            String s = evento.getIdTipoSacramento().getNombre() + ", Folio " + evento.getFolio() + ", número " + evento.getNumero();
            this.selectedMov.setIdEvento(obj.getEvento());
            this.txtEvento.setText(s);
        }
    }//GEN-LAST:event_btnBuscarEventoActionPerformed

    private void btnEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEventoActionPerformed
        this.movimientoController.getSelected().setIdEvento(null);
        this.txtEvento.setText("");
    }//GEN-LAST:event_btnEliminarEventoActionPerformed

    private void btnEliminarEventoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEventoMouseMoved
        this.btnEliminarEvento.setBackground(new java.awt.Color(227, 96, 101));
    }//GEN-LAST:event_btnEliminarEventoMouseMoved

    private void btnEliminarEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEventoMouseExited
        this.btnEliminarEvento.setBackground(new java.awt.Color(222, 62, 68));
    }//GEN-LAST:event_btnEliminarEventoMouseExited

    private void btnguardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseMoved
        this.btnguardar.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_btnguardarMouseMoved

    private void btnguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseExited
        this.btnguardar.setBackground(new java.awt.Color(0, 129, 255));
    }//GEN-LAST:event_btnguardarMouseExited

    private void btncancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseMoved
        this.btncancelar.setBackground(new java.awt.Color(254, 203, 46));
    }//GEN-LAST:event_btncancelarMouseMoved

    private void btncancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseExited
        this.btncancelar.setBackground(new java.awt.Color(254, 192, 1));
    }//GEN-LAST:event_btncancelarMouseExited

    private void btnBuscarEventoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarEventoMouseMoved
        this.btnBuscarEvento.setBackground(new java.awt.Color(132, 142, 149));
    }//GEN-LAST:event_btnBuscarEventoMouseMoved

    private void btnBuscarEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarEventoMouseExited
        this.btnBuscarEvento.setBackground(new java.awt.Color(107, 117, 125));
    }//GEN-LAST:event_btnBuscarEventoMouseExited

    private void jbsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsalirMouseMoved
        this.jbsalir.setBackground(new java.awt.Color(227, 96, 101));
    }//GEN-LAST:event_jbsalirMouseMoved

    private void jbsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsalirMouseExited
        this.jbsalir.setBackground(new java.awt.Color(222, 62, 68));
    }//GEN-LAST:event_jbsalirMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMoverJDialog.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMoverJDialog.MouseDraggedJDialog(evt, this);
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(DlgMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgMovEfectivo dialog = new DlgMovEfectivo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscarEvento;
    private javax.swing.JButton btnEliminarEvento;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<Justificacion> cbJustificacion;
    private javax.swing.JComboBox<String> cbTipoMovimiento;
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
    private javax.swing.JButton jbsalir;
    private com.toedter.calendar.JDateChooser jdFechaMov;
    private javax.swing.JSeparator jsEvento;
    private javax.swing.JSeparator jsMonto;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
