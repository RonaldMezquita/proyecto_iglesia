/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.SacerdoteController;
import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

/**
 *
 * @author remsf
 */
public class DlgBuscarSacerdote extends javax.swing.JDialog {

    private SacerdoteController sacerdoteController;
    private Sacerdote sacerdote;
    private javax.swing.JFormattedTextField txtBuscarDui;
    private Usuario usuarioLogeado;
    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }


    public Sacerdote getSacerdote() {
        return sacerdote;
    }

    /**
     * Creates new form DlgBuscarSacerdote
     */
    public DlgBuscarSacerdote(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.sacerdoteController = new SacerdoteController();
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
//        new TextPrompt("Digite nombres, apellidos o DUI para realizar la busqueda", this.txtBuscar);
        this.txtBuscar.requestFocus();
        this.loadTxtBuscarDui();
        new TextPrompt("Digite nombre para realizar la busqueda", this.txtBuscar);
//        getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Metodo para cargar el JTextField para buscar por DUI
     */
    private void loadTxtBuscarDui() {
        this.txtBuscarDui = ProjectUtils.getCampoDui();
        this.txtBuscarDui.setName("dui");
        this.txtBuscarDui.setFont(new java.awt.Font("Tahoma", 0, 12));
        this.txtBuscarDui.setVisible(false);
        this.txtBuscarDui.setBorder(null);
        this.txtBuscarDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarDuiKeyReleased(evt);
            }
        });
        jPanel1.add(this.txtBuscarDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 24));
    }

    private void mostrarTabla(String filtro, TipoBusquedaEnum tipo) {
        this.sacerdoteController.llenarTablaBusqueda(tbSacerdote, filtro, tipo);
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
        jsBusqueda = new javax.swing.JSeparator();
        jsBusquedaDui = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSacerdote = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnNuevoSacerdote = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbTipoBusqueda = new javax.swing.JComboBox<>();
        jPanelTop = new javax.swing.JPanel();
        jbCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(520, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jsBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        jsBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        jsBusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jsBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, -1));

        jsBusquedaDui.setBackground(new java.awt.Color(153, 153, 153));
        jsBusquedaDui.setForeground(new java.awt.Color(0, 0, 0));
        jsBusquedaDui.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jsBusquedaDui, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, -1));

        tbSacerdote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbSacerdote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Completo", "DUI", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tbSacerdote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbSacerdote.setRowHeight(25);
        tbSacerdote.getTableHeader().setReorderingAllowed(false);
        tbSacerdote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSacerdoteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSacerdote);
        if (tbSacerdote.getColumnModel().getColumnCount() > 0) {
            tbSacerdote.getColumnModel().getColumn(0).setMinWidth(30);
            tbSacerdote.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbSacerdote.getColumnModel().getColumn(0).setMaxWidth(45);
            tbSacerdote.getColumnModel().getColumn(2).setMinWidth(90);
            tbSacerdote.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbSacerdote.getColumnModel().getColumn(2).setMaxWidth(90);
            tbSacerdote.getColumnModel().getColumn(3).setMinWidth(25);
            tbSacerdote.getColumnModel().getColumn(3).setPreferredWidth(25);
            tbSacerdote.getColumnModel().getColumn(3).setMaxWidth(25);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 485, 250));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 280, 24));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/detalle.png"))); // NOI18N
        jLabel1.setText("Haga click en el boton seleccionar para elegir un sacerdote");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, -1));

        btnNuevoSacerdote.setBackground(new java.awt.Color(27, 163, 69));
        btnNuevoSacerdote.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoSacerdote.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoSacerdote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/agregar-w-24px.png"))); // NOI18N
        btnNuevoSacerdote.setText("Nuevo sacedote");
        btnNuevoSacerdote.setBorder(null);
        btnNuevoSacerdote.setBorderPainted(false);
        btnNuevoSacerdote.setContentAreaFilled(false);
        btnNuevoSacerdote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoSacerdote.setOpaque(true);
        btnNuevoSacerdote.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNuevoSacerdoteMouseMoved(evt);
            }
        });
        btnNuevoSacerdote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoSacerdoteMouseExited(evt);
            }
        });
        btnNuevoSacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoSacerdoteActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoSacerdote, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 150, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar-b-24px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Seleccione tipo de busqueda");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jcbTipoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jcbTipoBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Nombre", "Por DUI" }));
        jcbTipoBusqueda.setBorder(null);
        jcbTipoBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoBusquedaItemStateChanged(evt);
            }
        });
        jPanel1.add(jcbTipoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 180, 30));

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
        jPanelTop.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 30, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Busqueda de Sacerdote");
        jPanelTop.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        jPanel1.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSacerdoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSacerdoteMouseClicked
        int column = this.tbSacerdote.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.tbSacerdote.getRowHeight();

        if (row < this.tbSacerdote.getRowCount() && row >= 0
                && column < this.tbSacerdote.getColumnCount() && column >= 0) {
            Object value = this.tbSacerdote.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                Integer id = Integer.parseInt(this.tbSacerdote.getValueAt(row, 0).toString());
                this.sacerdote = this.sacerdoteController.consultarPorId(id);
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }//GEN-LAST:event_tbSacerdoteMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.mostrarTabla(this.txtBuscar.getText(), TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarDuiKeyReleased(java.awt.event.KeyEvent evt) {
        this.mostrarTabla(this.txtBuscarDui.getText(), TipoBusquedaEnum.DUI);
    }

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void btnNuevoSacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoSacerdoteActionPerformed
        DlgSacerdote obj = new DlgSacerdote(null, true);
        obj.setUsuarioLogeado(this.usuarioLogeado);
        obj.setVisible(true);
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_btnNuevoSacerdoteActionPerformed

    private void jcbTipoBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoBusquedaItemStateChanged
        switch (this.jcbTipoBusqueda.getSelectedIndex()) {
            case 0: // Por nombre
                this.txtBuscar.setText("");
                this.txtBuscarDui.setText("");
                this.txtBuscarDui.setVisible(false);
                this.txtBuscar.setVisible(true);
                this.txtBuscar.requestFocus();
                this.jsBusqueda.setVisible(true);
                this.jsBusquedaDui.setVisible(false);
                this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
                break;
            case 1: // Por DUI
                this.txtBuscar.setText("");
                this.txtBuscarDui.setText("");
                this.txtBuscar.setVisible(false);
                this.txtBuscarDui.setVisible(true);
                this.txtBuscarDui.requestFocus();
                this.jsBusqueda.setVisible(false);
                this.jsBusquedaDui.setVisible(true);
        }
    }//GEN-LAST:event_jcbTipoBusquedaItemStateChanged

    private void jbCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarMouseMoved
        this.jbCerrar.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_jbCerrarMouseMoved

    private void jbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarMouseExited
        this.jbCerrar.setBackground(new java.awt.Color(0,129,255));
    }//GEN-LAST:event_jbCerrarMouseExited

    private void btnNuevoSacerdoteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoSacerdoteMouseMoved
        this.btnNuevoSacerdote.setBackground(new java.awt.Color(35, 212, 89));
    }//GEN-LAST:event_btnNuevoSacerdoteMouseMoved

    private void btnNuevoSacerdoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoSacerdoteMouseExited
        this.btnNuevoSacerdote.setBackground(new java.awt.Color(27, 163, 69));
    }//GEN-LAST:event_btnNuevoSacerdoteMouseExited

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
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarSacerdote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgBuscarSacerdote dialog = new DlgBuscarSacerdote(new javax.swing.JDialog(), true
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
    private javax.swing.JButton btnNuevoSacerdote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JComboBox<String> jcbTipoBusqueda;
    private javax.swing.JSeparator jsBusqueda;
    private javax.swing.JSeparator jsBusquedaDui;
    private javax.swing.JTable tbSacerdote;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
