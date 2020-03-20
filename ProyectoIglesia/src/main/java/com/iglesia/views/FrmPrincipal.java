/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

/**
 *
 * @author remsf
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalFrame
     */
    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jbAbrirDialog = new javax.swing.JButton();
        btnSacerdotes = new javax.swing.JButton();
        btnLugares = new javax.swing.JButton();
        btnTiposSacramento = new javax.swing.JButton();
        btnBoda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(46, 46, 46));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAbrirDialog.setBackground(new java.awt.Color(62, 69, 81));
        jbAbrirDialog.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbAbrirDialog.setForeground(new java.awt.Color(255, 255, 255));
        jbAbrirDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/x26-clientes.png"))); // NOI18N
        jbAbrirDialog.setText("Personas");
        jbAbrirDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbrirDialogActionPerformed(evt);
            }
        });
        panelMenu.add(jbAbrirDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnSacerdotes.setBackground(new java.awt.Color(62, 69, 81));
        btnSacerdotes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSacerdotes.setForeground(new java.awt.Color(255, 255, 255));
        btnSacerdotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Icon/x26-clientes.png"))); // NOI18N
        btnSacerdotes.setText("Sacerdotes");
        btnSacerdotes.setToolTipText("");
        btnSacerdotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacerdotesActionPerformed(evt);
            }
        });
        panelMenu.add(btnSacerdotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        btnLugares.setBackground(new java.awt.Color(62, 69, 81));
        btnLugares.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLugares.setForeground(new java.awt.Color(255, 255, 255));
        btnLugares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Icon/x26-clientes.png"))); // NOI18N
        btnLugares.setText("Mantenimiento de Lugar");
        btnLugares.setToolTipText("");
        btnLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLugaresActionPerformed(evt);
            }
        });
        panelMenu.add(btnLugares, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 0, -1, -1));

        btnTiposSacramento.setBackground(new java.awt.Color(62, 69, 81));
        btnTiposSacramento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTiposSacramento.setForeground(new java.awt.Color(255, 255, 255));
        btnTiposSacramento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Icon/x26-clientes.png"))); // NOI18N
        btnTiposSacramento.setText("Tipos de sacramentos");
        btnTiposSacramento.setToolTipText("");
        btnTiposSacramento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposSacramentoActionPerformed(evt);
            }
        });
        panelMenu.add(btnTiposSacramento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 40));

        btnBoda.setBackground(new java.awt.Color(62, 69, 81));
        btnBoda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBoda.setForeground(new java.awt.Color(255, 255, 255));
        btnBoda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Icon/x26-clientes.png"))); // NOI18N
        btnBoda.setText("Boda");
        btnBoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBodaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBoda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAbrirDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbrirDialogActionPerformed
         DlgPersona obj = new DlgPersona(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_jbAbrirDialogActionPerformed

    private void btnBodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBodaActionPerformed
        DlgBoda obj = new DlgBoda(this, true);
//        Shape rectangle = new RoundRectangle2D.Float(0, 0, 400, 200, 20, 20);
//        obj.setShape(rectangle);
        obj.setVisible(true);
    }//GEN-LAST:event_btnBodaActionPerformed

    private void btnSacerdotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacerdotesActionPerformed
        DlgSacerdote obj = new DlgSacerdote(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_btnSacerdotesActionPerformed

    private void btnLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugaresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLugaresActionPerformed

    private void btnTiposSacramentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposSacramentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiposSacramentoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoda;
    private javax.swing.JButton btnLugares;
    private javax.swing.JButton btnSacerdotes;
    private javax.swing.JButton btnTiposSacramento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbAbrirDialog;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
