/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import com.iglesia.controllers.DepartamentoController;
import com.iglesia.controllers.PersonaController;
import com.iglesia.entities.Departamento;
import com.iglesia.entities.Persona;
import com.iglesia.utils.ProjectUtils;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
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
    private final DepartamentoController departamentoController;
    private List<String> excepciones = new ArrayList<>();
    private boolean redirect;
    private Persona personaToEdit;
    
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
    
    public void setPersonaToEdit(Persona personaToEdit) {
        this.personaToEdit = personaToEdit;
        if (this.personaToEdit != null) {
            this.txtid.setText(this.personaToEdit.getId().toString());
            this.txtnombres.setText(this.personaToEdit.getNombres());
            this.txtapellidos.setText(this.personaToEdit.getApellidos());
            this.txtdui.setText(this.personaToEdit.getDui());
            this.txtnit.setText(this.personaToEdit.getNit());
            this.txtfechanacimiento.setDate(this.personaToEdit.getFechaNacimiento());
            if (this.personaToEdit.getGenero().equals("M")) {
                this.rbMasculino.setSelected(true);
            }else{
                this.rbFemenino.setSelected(true);
            }
            this.txtdireccion.setText(this.personaToEdit.getDireccion());
            this.cbestado.setSelected(this.personaToEdit.getEstado());
            this.cbDepartamento.setSelectedItem(this.personaToEdit.getIdDepartamento());
        }
    }
    
    public DlgPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.personaController = new PersonaController();
        this.departamentoController = new DepartamentoController();
        this.departamentoController.getCombobox(this.cbDepartamento);
        // comienza generacion de campos formateados
        txtdui = ProjectUtils.getCampoDui();
        txtdui.setName("dui");
        txtdui.setFont(new java.awt.Font("Dialog", 0, 14));
        jPanel1.add(txtdui, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, 90, -1));
        
        txtnit = ProjectUtils.getCampoNit();
        txtnit.setName("nit");
        txtnit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 240, 142, -1));
        // termina generacion de campos formateados
        this.setLocationRelativeTo(null);
        this.txtnombres.requestFocus();
        this.excepciones.add("buscar");
        this.excepciones.add("dui");
        this.excepciones.add("nit");
        this.txtid.setVisible(false);
        this.cbestado.setSelected(true);
        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }
    
    private void crear() {
        this.excepciones.add("idPersona");
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.personaController.crear() != null) {
            Integer respuesta = 1;
            if (this.redirect) {
                respuesta = JOptionPane.showConfirmDialog(this,
                        "Registro guardado correctamente. ¿Quiere ver listado de personas?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registro guardado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            if (respuesta == 0) {
                DlgConsultaPersona obj = new DlgConsultaPersona((Frame) this.getParent(), true);
                obj.setVisible(true);
                this.setVisible(false);
            } else if (respuesta == 1) {
                ProjectUtils.limpiarComponentes(this.jPanel1);
            }
        }
        
    }
    
    private void actualizar() {
        if (ProjectUtils.validarVacios(this.jPanel1, this.excepciones)) {
            JOptionPane.showMessageDialog(this, "Campo(s) Requerido(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.personaController.actualizar() != null) {
//            Integer respuesta = JOptionPane.showConfirmDialog(this,
//                    "Registro actualizado correctamente. ¿Quiere ver listado de personas?",
//                    "Confirmación",
//                    JOptionPane.YES_NO_OPTION);
//            if (respuesta == 0) {
//                DlgConsultaPersona obj = new DlgConsultaPersona((Frame) this.getParent(), true);
//                obj.setVisible(true);
//                this.setVisible(false);
//            } else if (respuesta == 1) {
//                ProjectUtils.limpiarComponentes(this.jPanel1);
//            }

            JOptionPane.showMessageDialog(this, "Registro actualizado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            ProjectUtils.limpiarComponentes(this.jPanel1);
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

        btnGroupGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtfechanacimiento = new com.toedter.calendar.JDateChooser();
        txtid = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        cbestado = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setForeground(new java.awt.Color(189, 189, 189));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Personas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 430, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 70, -1, -1));

        txtnombres.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 90, 270, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, -1, -1));

        txtapellidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 140, 270, -1));

        btnSalir.setBackground(new java.awt.Color(204, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 32));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DUI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 550, -1, -1));

        txtdireccion.setColumns(20);
        txtdireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtdireccion.setRows(5);
        jScrollPane1.setViewportView(txtdireccion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 450, 270, 90));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de nacimiento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 280, -1, -1));

        txtfechanacimiento.setDateFormatString("dd/MM/yyyy");
        txtfechanacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 300, 160, -1));

        txtid.setName("idPersona"); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 20, 40, -1));

        btnguardar.setBackground(new java.awt.Color(13, 71, 161));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/save.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 600, -1, -1));

        btncancelar.setBackground(new java.awt.Color(255, 136, 0));
        btncancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cancel.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, -1, -1));

        cbestado.setForeground(new java.awt.Color(255, 255, 255));
        cbestado.setText("Activo");
        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 570, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Originario");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 380, -1, -1));

        btnGroupGenero.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbMasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbMasculino.setSelected(true);
        rbMasculino.setText("Masculino");
        rbMasculino.setActionCommand("M");
        jPanel1.add(rbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 350, -1, -1));

        btnGroupGenero.add(rbFemenino);
        rbFemenino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbFemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbFemenino.setText("Femenino");
        rbFemenino.setActionCommand("F");
        jPanel1.add(rbFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 430, -1, -1));

        cbDepartamento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(cbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 400, 270, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Genero");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 330, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
//        this.personaController.prepararCrear();
        this.personaController.getSelected().setId((this.txtid.getText().equals("")) ? null : Integer.parseInt(this.txtid.getText()));
        this.personaController.getSelected().setNombres(this.txtnombres.getText());
        this.personaController.getSelected().setApellidos(this.txtapellidos.getText());
        this.personaController.getSelected().setDui(this.txtdui.getText());
        this.personaController.getSelected().setNit(this.txtnit.getText());
        this.personaController.getSelected().setGenero(this.btnGroupGenero.getSelection().getActionCommand());
        this.personaController.getSelected().setFechaNacimiento(this.txtfechanacimiento.getDate());
        this.personaController.getSelected().setIdDepartamento((Departamento) this.cbDepartamento.getSelectedItem());
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
    }//GEN-LAST:event_btncancelarActionPerformed

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
    private javax.swing.ButtonGroup btnGroupGenero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<Departamento> cbDepartamento;
    private javax.swing.JCheckBox cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextArea txtdireccion;
    private com.toedter.calendar.JDateChooser txtfechanacimiento;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
