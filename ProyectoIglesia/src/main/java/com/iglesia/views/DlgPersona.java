/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.PersonaController;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.TextPrompt;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class DlgPersona extends javax.swing.JDialog {

    /**
     * Creates new form DlgPersona
     */
    private javax.swing.JFormattedTextField txtdui;
    private javax.swing.JFormattedTextField txtnit;
    private PersonaController personaController;
    private List<String> excepciones = new ArrayList<>();
    
    public DlgPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.personaController = new PersonaController();
        // comienza generacion de campos formateados
        txtdui = ProjectUtils.getCampoDui();
        txtdui.setName("dui");
        txtdui.setFont(new java.awt.Font("Dialog", 0, 14));
        jPanel1.add(txtdui, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 90, -1));

        txtnit = ProjectUtils.getCampoNit();
        txtnit.setName("nit");
        txtnit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 142, -1));
        // termina generacion de campos formateados
        this.setLocationRelativeTo(null);
        this.txtnombres.requestFocus();
        this.excepciones.add("buscar");
        this.excepciones.add("dui");
        this.excepciones.add("nit");
        this.txtid.setVisible(false);
        this.mostrarTabla("");
        new TextPrompt("Digite para buscar en nombres o apellidos", this.txtbuscar);
        this.cbestado.setSelected(true);
    }
    
    private void mostrarTabla(String filtro) {
        this.personaController.llenarTabla(tbpersona, filtro);
    }

    private void crear() {
        this.excepciones.add("idPersona");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.personaController.crear() != null) {
            JOptionPane.showMessageDialog(this, "Registro guardado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            ProjectUtils.limpiarComponentes(this.jPanel1);
            this.mostrarTabla("");
        }

    }

    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.personaController.actualizar() != null) {
            JOptionPane.showMessageDialog(this, "Registro actualizado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            ProjectUtils.limpiarComponentes(this.jPanel1);
            this.mostrarTabla("");
        }

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
        txtnombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        txtsalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtfechanacimiento = new com.toedter.calendar.JDateChooser();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpersona = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        cbestado = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setForeground(new java.awt.Color(189, 189, 189));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mantenimiento de Personas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, -1, -1));

        txtnombres.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 230, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, -1));

        txtapellidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 230, -1));

        txtsalir.setBackground(new java.awt.Color(204, 0, 0));
        txtsalir.setForeground(new java.awt.Color(255, 255, 255));
        txtsalir.setText("Salir");
        txtsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsalirActionPerformed(evt);
            }
        });
        jPanel1.add(txtsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 70, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DUI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, -1, -1));

        txtdireccion.setColumns(20);
        txtdireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtdireccion.setRows(5);
        jScrollPane1.setViewportView(txtdireccion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 270, 90));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de nacimiento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, -1, -1));

        txtfechanacimiento.setDateFormatString("dd/MM/yyyy");
        txtfechanacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 160, -1));

        btnguardar.setBackground(new java.awt.Color(13, 71, 161));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 530, -1, -1));

        btncancelar.setBackground(new java.awt.Color(255, 136, 0));
        btncancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, -1, -1));

        txtid.setName("idPersona"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 40, -1));

        tbpersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "DUI", "NIT", "F.Nacimiento", "Direccion", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbpersona.getTableHeader().setReorderingAllowed(false);
        tbpersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpersona);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 830, 400));

        txtbuscar.setName("buscar"); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 380, -1));

        cbestado.setForeground(new java.awt.Color(255, 255, 255));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Direccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsalirActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_txtsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        this.personaController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.personaController.getSelected().setNombres(this.txtnombres.getText());
        this.personaController.getSelected().setApellidos(this.txtapellidos.getText());
        this.personaController.getSelected().setDui(this.txtdui.getText());
        this.personaController.getSelected().setNit(this.txtnit.getText());
        this.personaController.getSelected().setFechaNacimiento(this.txtfechanacimiento.getDate());
        this.personaController.getSelected().setDireccion(this.txtdireccion.getText());
        this.personaController.getSelected().setEstado(this.cbestado.isSelected());
        if (this.txtid.getText().equals("")) {
            this.crear();
        } else {
            this.actualizar();
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        ProjectUtils.limpiarComponentes(this.jPanel1);
        this.mostrarTabla("");
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tbpersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpersonaMouseClicked
        try {
            int rowSelected = this.tbpersona.getSelectedRow();
            this.txtid.setText(this.tbpersona.getValueAt(rowSelected, 0).toString());
            this.txtnombres.setText(this.tbpersona.getValueAt(rowSelected, 1).toString());
            this.txtapellidos.setText(this.tbpersona.getValueAt(rowSelected, 2).toString());
            String dui = this.tbpersona.getValueAt(rowSelected, 3) != null ? this.tbpersona.getValueAt(rowSelected, 3).toString() : "";
            this.txtdui.setText(dui);
            String nit = this.tbpersona.getValueAt(rowSelected, 4) != null ? this.tbpersona.getValueAt(rowSelected, 4).toString() : "";
            this.txtnit.setText(nit);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.txtfechanacimiento.setDate(sdf.parse(this.tbpersona.getValueAt(rowSelected, 5).toString()));
            this.txtdireccion.setText(this.tbpersona.getValueAt(rowSelected, 6).toString());
            this.cbestado.setSelected(this.tbpersona.getValueAt(rowSelected, 7).toString() == "Activo" ? true : false);
        } catch (ParseException ex) {
            System.out.println("Error de parseo");
        }
    }//GEN-LAST:event_tbpersonaMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        this.mostrarTabla(this.txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

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
            java.util.logging.Logger.getLogger(DlgPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgPersona dialog = new DlgPersona(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbpersona;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextArea txtdireccion;
    private com.toedter.calendar.JDateChooser txtfechanacimiento;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JButton txtsalir;
    // End of variables declaration//GEN-END:variables
}