/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import FiveCodMover.FiveCodMoverJDialog;
import com.iglesia.controllers.MovimientoController;
import com.iglesia.entities.Movimiento;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.FechasUtils;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Ronald Mezquita
 */
public class DlgConsultaMovEfectivo extends javax.swing.JDialog {

    private Usuario usuarioLogeado;

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    /**
     * Creates new form DlgConsultaMovEfectivo
     */
    private MovimientoController movimientoController;
    private List<String> excepciones = new ArrayList<>();
    private Movimiento selectedMov;

    public DlgConsultaMovEfectivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.movimientoController = new MovimientoController();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.excepciones.add("buscar");
        this.busquedaPorDefecto();

        this.movimientoController.getComboTipoMov(this.jcbTipoMovimiento);
        this.jlblTipoMov.setVisible(false);
        this.jcbTipoMovimiento.setVisible(false);
//        this.jcbTipoBusqueda.setUI(CustomComboBox.createUI(rootPane));
    }

    private void busquedaPorDefecto() {
        Object[] fechas = {FechasUtils.operateDate(FechasUtils.getCurrentDate(), -30), FechasUtils.getCurrentDate()};
        this.mostrarTabla(fechas, TipoBusquedaEnum.RANGO_FECHA);
    }

    private void mostrarTabla(Object[] filtro, TipoBusquedaEnum tipo) {
        this.movimientoController.llenarTablaConsulta(tbMovimiento, filtro, tipo);
    }

    private boolean validarFechas() {
        if (this.jdFechaIni.getDate() == null || this.jdFechaFin.getDate() == null) {
            DlgWindow.showMessageDialog(null, "Aviso", "Es necesario seleccionar un rango de fechas.!", DlgWindow.WARN);
            return false;
        }
        return true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovimiento = new javax.swing.JTable();
        jdFechaIni = new com.toedter.calendar.JDateChooser();
        jdFechaFin = new com.toedter.calendar.JDateChooser();
        jlblFFin = new javax.swing.JLabel();
        jlblFIni = new javax.swing.JLabel();
        jcbTipoMovimiento = new javax.swing.JComboBox<>();
        jlblTipoMov = new javax.swing.JLabel();
        jbtnBuscar = new javax.swing.JButton();
        jcbTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanelTop = new javax.swing.JPanel();
        jbsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 51));

        tbMovimiento.setBackground(new java.awt.Color(224, 224, 224));
        tbMovimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbMovimiento.setForeground(new java.awt.Color(0, 0, 0));
        tbMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Monto", "Tipo Mov.", "Sacramento", "Justificación", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbMovimiento.setRowHeight(25);
        tbMovimiento.setSelectionBackground(new java.awt.Color(189, 189, 189));
        tbMovimiento.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tbMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMovimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovimiento);
        if (tbMovimiento.getColumnModel().getColumnCount() > 0) {
            tbMovimiento.getColumnModel().getColumn(0).setMinWidth(30);
            tbMovimiento.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbMovimiento.getColumnModel().getColumn(0).setMaxWidth(45);
            tbMovimiento.getColumnModel().getColumn(1).setMinWidth(80);
            tbMovimiento.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbMovimiento.getColumnModel().getColumn(1).setMaxWidth(80);
            tbMovimiento.getColumnModel().getColumn(2).setMinWidth(85);
            tbMovimiento.getColumnModel().getColumn(2).setPreferredWidth(85);
            tbMovimiento.getColumnModel().getColumn(2).setMaxWidth(85);
            tbMovimiento.getColumnModel().getColumn(3).setMinWidth(80);
            tbMovimiento.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbMovimiento.getColumnModel().getColumn(3).setMaxWidth(80);
            tbMovimiento.getColumnModel().getColumn(4).setMinWidth(110);
            tbMovimiento.getColumnModel().getColumn(4).setPreferredWidth(110);
            tbMovimiento.getColumnModel().getColumn(4).setMaxWidth(110);
            tbMovimiento.getColumnModel().getColumn(6).setMinWidth(25);
            tbMovimiento.getColumnModel().getColumn(6).setPreferredWidth(25);
            tbMovimiento.getColumnModel().getColumn(6).setMaxWidth(25);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 640, 310));

        jdFechaIni.setBackground(new java.awt.Color(255, 255, 255));
        jdFechaIni.setForeground(new java.awt.Color(55, 71, 79));
        jdFechaIni.setDateFormatString("dd/MM/yyyy");
        jdFechaIni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jdFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 150, 30));

        jdFechaFin.setBackground(new java.awt.Color(255, 255, 255));
        jdFechaFin.setForeground(new java.awt.Color(55, 71, 79));
        jdFechaFin.setDateFormatString("dd/MM/yyyy");
        jdFechaFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jdFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 150, 30));

        jlblFFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblFFin.setForeground(new java.awt.Color(0, 0, 0));
        jlblFFin.setText("F. Inicio");
        jPanel1.add(jlblFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jlblFIni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblFIni.setForeground(new java.awt.Color(0, 0, 0));
        jlblFIni.setText("F. Fin");
        jPanel1.add(jlblFIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jcbTipoMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        jcbTipoMovimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTipoMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        jcbTipoMovimiento.setBorder(null);
        jPanel1.add(jcbTipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 135, 170, 30));

        jlblTipoMov.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblTipoMov.setForeground(new java.awt.Color(0, 0, 0));
        jlblTipoMov.setText("Tipo de Mov.");
        jPanel1.add(jlblTipoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jbtnBuscar.setBackground(new java.awt.Color(107, 117, 125));
        jbtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar-w-24px.png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBorderPainted(false);
        jbtnBuscar.setContentAreaFilled(false);
        jbtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBuscar.setOpaque(true);
        jbtnBuscar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnBuscarMouseMoved(evt);
            }
        });
        jbtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnBuscarMouseExited(evt);
            }
        });
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 90, 40));

        jcbTipoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jcbTipoBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por rango de fechas", "Por tipo de movimiento", "Mixto" }));
        jcbTipoBusqueda.setBorder(null);
        jcbTipoBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoBusquedaItemStateChanged(evt);
            }
        });
        jPanel1.add(jcbTipoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seleccione tipo de busqueda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanelTop.setBackground(new java.awt.Color(0, 129, 255));
        jPanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbsalir.setBackground(new java.awt.Color(0, 129, 255));
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
        jPanelTop.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 30, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Movimientos de Efectivo");
        jPanelTop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        jPanel1.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMovimientoMouseClicked
        int column = this.tbMovimiento.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = this.tbMovimiento.getSelectedRow();

        if (column >= 0 && column < this.tbMovimiento.getColumnCount()
                && row >= 0 && row < this.tbMovimiento.getRowCount()) {
            Object btn = this.tbMovimiento.getValueAt(row, column);
            if (column == 6) {
                if (btn instanceof JButton) {
                    ((JButton) btn).doClick();
                    Integer id = Integer.parseInt(this.tbMovimiento.getValueAt(row, 0).toString());
                    this.selectedMov = this.movimientoController.consultarPorId(id);
                    DlgMovEfectivo obj = new DlgMovEfectivo(null, true);
                    obj.setSelectedMov(this.selectedMov);
                    obj.setUsuarioLogeado(this.usuarioLogeado);
                    obj.setRedirect(true);
                    obj.setVisible(true);
                    this.busquedaPorDefecto();
                }
            }
        }
    }//GEN-LAST:event_tbMovimientoMouseClicked

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jbtnBuscarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnBuscarMouseMoved
        this.jbtnBuscar.setBackground(new java.awt.Color(132, 142, 149));
    }//GEN-LAST:event_jbtnBuscarMouseMoved

    private void jbtnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnBuscarMouseExited
        this.jbtnBuscar.setBackground(new java.awt.Color(107, 117, 125));
    }//GEN-LAST:event_jbtnBuscarMouseExited

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        Object[] filtros = new Object[3];
        switch (this.jcbTipoBusqueda.getSelectedIndex()) {
            case 0:
                if (this.validarFechas()) {
                    filtros[0] = this.jdFechaIni.getDate();
                    filtros[1] = this.jdFechaFin.getDate();
                    this.mostrarTabla(filtros, TipoBusquedaEnum.RANGO_FECHA);
                }
                break;
            case 1:
                filtros[0] = this.jcbTipoMovimiento.getSelectedItem();
                this.mostrarTabla(filtros, TipoBusquedaEnum.TIPO_MOV);
                break;
            case 2:
                if (this.validarFechas()) {
                    filtros[0] = this.jdFechaIni.getDate();
                    filtros[1] = this.jdFechaFin.getDate();
                    filtros[2] = this.jcbTipoMovimiento.getSelectedItem();
                    this.mostrarTabla(filtros, TipoBusquedaEnum.RANGO_FECHAS_TIPOMOV);
                }
                break;
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jcbTipoBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoBusquedaItemStateChanged
        switch (this.jcbTipoBusqueda.getSelectedIndex()) {
            case 0:
                this.jlblFIni.setVisible(true);
                this.jlblFFin.setVisible(true);
                this.jdFechaIni.setVisible(true);
                this.jdFechaFin.setVisible(true);
                this.jlblTipoMov.setVisible(false);
                this.jcbTipoMovimiento.setVisible(false);
                break;
            case 1:
                this.jlblFIni.setVisible(false);
                this.jlblFFin.setVisible(false);
                this.jdFechaIni.setVisible(false);
                this.jdFechaFin.setVisible(false);
                this.jlblTipoMov.setVisible(true);
                jPanel1.add(this.jlblTipoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));
                this.jcbTipoMovimiento.setVisible(true);
                jPanel1.add(this.jcbTipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 135, 170, 30));
                break;
            case 2:
                this.jlblFIni.setVisible(true);
                this.jlblFFin.setVisible(true);
                this.jdFechaIni.setVisible(true);
                this.jdFechaFin.setVisible(true);
                jPanel1.add(this.jlblTipoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));
                this.jlblTipoMov.setVisible(true);
                this.jcbTipoMovimiento.setVisible(true);
                jPanel1.add(this.jcbTipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 175, 170, 30));
                break;
        }
    }//GEN-LAST:event_jcbTipoBusquedaItemStateChanged

    private void jbsalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsalirMouseMoved
        this.jbsalir.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_jbsalirMouseMoved

    private void jbsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsalirMouseExited
        this.jbsalir.setBackground(new java.awt.Color(0, 129, 255));
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
            java.util.logging.Logger.getLogger(DlgConsultaMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultaMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultaMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultaMovEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                DlgConsultaMovEfectivo dialog = new DlgConsultaMovEfectivo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbsalir;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JComboBox<String> jcbTipoBusqueda;
    private javax.swing.JComboBox<String> jcbTipoMovimiento;
    private com.toedter.calendar.JDateChooser jdFechaFin;
    private com.toedter.calendar.JDateChooser jdFechaIni;
    private javax.swing.JLabel jlblFFin;
    private javax.swing.JLabel jlblFIni;
    private javax.swing.JLabel jlblTipoMov;
    private javax.swing.JTable tbMovimiento;
    // End of variables declaration//GEN-END:variables
}
