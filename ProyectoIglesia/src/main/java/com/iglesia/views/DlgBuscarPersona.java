/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.PersonaController;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.ProjectUtils;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

/**
 *
 * @author remsf
 */
public class DlgBuscarPersona extends javax.swing.JDialog {

    private PersonaController personaController;
    private Persona persona;
    private javax.swing.JFormattedTextField txtBuscarDui;
    private Usuario usuarioLogeado;

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public Persona getPersona() {
        return persona;
    }

    /**
     * Creates new form DlgBuscarPersona
     */
    public DlgBuscarPersona(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.personaController = new PersonaController();
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
//        new TextPrompt("Digite nombres, apellidos o DUI para realizar la busqueda", this.txtBuscar);
//        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.txtBuscar.requestFocus();
        this.loadTxtBuscarDui();

    }

    /**
     * Metodo para cargar el JTextField para buscar por DUI
     */
    private void loadTxtBuscarDui() {
        this.txtBuscarDui = ProjectUtils.getCampoDui();
        this.txtBuscarDui.setName("dui");
        this.txtBuscarDui.setFont(new java.awt.Font("Tahoma", 0, 12));
        this.txtBuscarDui.setBackground(new java.awt.Color(255, 255, 255));
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
        this.personaController.llenarTablaBusqueda(tbpersona, filtro, tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBusqueda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jsBusqueda = new javax.swing.JSeparator();
        jsBusquedaDui = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jcbTipoBusqueda = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpersona = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaPersona = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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

        tbpersona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbpersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "DUI", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tbpersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbpersona.setRowHeight(25);
        tbpersona.getTableHeader().setReorderingAllowed(false);
        tbpersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpersona);
        if (tbpersona.getColumnModel().getColumnCount() > 0) {
            tbpersona.getColumnModel().getColumn(0).setMinWidth(30);
            tbpersona.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbpersona.getColumnModel().getColumn(0).setMaxWidth(45);
            tbpersona.getColumnModel().getColumn(3).setResizable(false);
            tbpersona.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbpersona.getColumnModel().getColumn(4).setMinWidth(25);
            tbpersona.getColumnModel().getColumn(4).setPreferredWidth(25);
            tbpersona.getColumnModel().getColumn(4).setMaxWidth(25);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 485, 270));

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
        jLabel1.setText("Haga click en el boton seleccionar para elegir una persona");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, -1));

        btnNuevaPersona.setBackground(new java.awt.Color(27, 163, 69));
        btnNuevaPersona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNuevaPersona.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/agregar-w-24px.png"))); // NOI18N
        btnNuevaPersona.setText("Nueva persona");
        btnNuevaPersona.setBorder(null);
        btnNuevaPersona.setBorderPainted(false);
        btnNuevaPersona.setContentAreaFilled(false);
        btnNuevaPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaPersona.setOpaque(true);
        btnNuevaPersona.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNuevaPersonaMouseMoved(evt);
            }
        });
        btnNuevaPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevaPersonaMouseExited(evt);
            }
        });
        btnNuevaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 150, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/buscar-b-24px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

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
        jLabel2.setText("Busqueda de Personas");
        jPanelTop.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        jPanel1.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbpersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpersonaMouseClicked
        int column = this.tbpersona.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / this.tbpersona.getRowHeight();

        if (row < this.tbpersona.getRowCount() && row >= 0
                && column < this.tbpersona.getColumnCount() && column >= 0) {
            Object value = this.tbpersona.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                Integer id = Integer.parseInt(this.tbpersona.getValueAt(row, 0).toString());
                this.persona = this.personaController.consultarPorId(id);
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }//GEN-LAST:event_tbpersonaMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.mostrarTabla(this.txtBuscar.getText(), TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarDuiKeyReleased(java.awt.event.KeyEvent evt) {
        this.mostrarTabla(this.txtBuscarDui.getText(), TipoBusquedaEnum.DUI);
    }

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void btnNuevaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPersonaActionPerformed
        DlgPersona obj = new DlgPersona(null, true);
        obj.setUsuarioLogeado(this.usuarioLogeado);
        obj.setVisible(true);
        this.mostrarTabla("", TipoBusquedaEnum.NOMBRE);
    }//GEN-LAST:event_btnNuevaPersonaActionPerformed

    private void btnNuevaPersonaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaPersonaMouseMoved
        this.btnNuevaPersona.setBackground(new java.awt.Color(35, 212, 89));
    }//GEN-LAST:event_btnNuevaPersonaMouseMoved

    private void btnNuevaPersonaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaPersonaMouseExited
        this.btnNuevaPersona.setBackground(new java.awt.Color(27, 163, 69));
    }//GEN-LAST:event_btnNuevaPersonaMouseExited

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
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgBuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgBuscarPersona dialog = new DlgBuscarPersona(new javax.swing.JDialog(), true
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
    private javax.swing.ButtonGroup bgBusqueda;
    private javax.swing.JButton btnNuevaPersona;
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
    private javax.swing.JTable tbpersona;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
