/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.views;

import java.awt.Image;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author remsf
 */
public class DlgWindow extends javax.swing.JDialog {

//    private String titulo, mensaje, textoBoton;
    public static Integer respuesta;
    private static Integer SI = 0;
    private final static Integer NO = 1;
    private final static String CONFIRM = "CONFIRMACION";
    private final static String MESSAGE = "MESSAGE";
    public final static String INFO = "INFO";
    public final static String WARN = "WARN";
    public final static String ERROR = "ERROR";

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//        this.jlblTitulo.setText(this.titulo);
//    }
//
//    public void setMensaje(String mensaje) {
//        this.mensaje = mensaje;
//        this.jtxtMensaje.setText(this.mensaje);
//    }
//
//    public void setTextoBoton(String textoBoton) {
//        this.textoBoton = textoBoton;
//        this.jbtnSi.setText(this.textoBoton);
//    }
//
//    public String getRespuesta() {
//        return respuesta;
//    }
//
//    public void setTipoVentana(String tipo) {
//        if (tipo.equals(INFO)) {
//            this.jbtnNo.setVisible(false);
//        } else if (tipo.equals(CONFIRM)) {
//            this.jbtnNo.setVisible(true);
//        }
//    }
    //</editor-fold>
    /**
     * Creates new form DlgWindow
     */
    private DlgWindow(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jlblTitulo.setText("");
        this.jtxtMensaje.setText("");
    }

    public DlgWindow(JDialog dialog, boolean bln, String titulo, String mensaje, String tipoVentana, String tipoMensaje) {
        this(dialog, bln);
        this.jlblTitulo.setText(titulo);
        this.jtxtMensaje.setText(mensaje);
        if (tipoVentana.equals(MESSAGE)) {
            this.jbtnSi.setText("Aceptar");
//            this.jbtnSi.setVisible(false);
            this.jbtnNo.setVisible(false);
            jpContenido.add(jbtnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 80, 70, 35));

            ImageIcon img = new ImageIcon(this.getClass().getResource("/META-INF/images/icon/info-icon-bl.png"));
            ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(this.jlblIcon.getWidth(), this.jlblIcon.getHeight(), Image.SCALE_DEFAULT));
            this.jlblIcon.setIcon(icon);
        } else if (tipoVentana.equals(CONFIRM)) {
            this.jbtnNo.setVisible(true);
            ImageIcon img = new ImageIcon(this.getClass().getResource("/META-INF/images/icon/question-icon-g.png"));
            ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(this.jlblIcon.getWidth(), this.jlblIcon.getHeight(), Image.SCALE_DEFAULT));
            this.jlblIcon.setIcon(icon);
        }

        if (tipoMensaje.equals(ERROR)) {
            this.jpTitulo.setBackground(new java.awt.Color(222, 62, 68));
            this.jbsalir.setBackground(new java.awt.Color(222, 62, 68));
            ImageIcon img = new ImageIcon(this.getClass().getResource("/META-INF/images/icon/error-icon-r.png"));
            ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(this.jlblIcon.getWidth(), this.jlblIcon.getHeight(), Image.SCALE_DEFAULT));
            this.jlblIcon.setIcon(icon);
        } else if (tipoMensaje.equals(WARN)) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("/META-INF/images/icon/warn-icon-y.png"));
            ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(this.jlblIcon.getWidth(), this.jlblIcon.getHeight(), Image.SCALE_DEFAULT));
            this.jlblIcon.setIcon(icon);
            this.jpTitulo.setBackground(new java.awt.Color(254, 192, 1));
            this.jbsalir.setBackground(new java.awt.Color(254, 192, 1));
        }

        this.setVisible(true);
    }

    public static void showMessageDialog(JDialog dialog, String titulo, String mensaje) {
        DlgWindow obj = new DlgWindow(dialog, true, titulo, mensaje, MESSAGE, INFO);
    }

    public static void showMessageDialog(JDialog dialog, String titulo, String mensaje, String tipo) {
        DlgWindow obj = new DlgWindow(dialog, true, titulo, mensaje, MESSAGE, tipo);
    }

    public static Integer showConfirmDialog(JDialog dialog, String titulo, String mensaje) {
        DlgWindow obj = new DlgWindow(dialog, true, titulo, mensaje, CONFIRM, INFO);
        return respuesta;
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
        jpTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jbsalir = new javax.swing.JButton();
        jpContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtMensaje = new javax.swing.JTextArea();
        jbtnSi = new javax.swing.JButton();
        jbtnNo = new javax.swing.JButton();
        jlblIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jPanel1.setMinimumSize(new java.awt.Dimension(370, 160));
        jPanel1.setPreferredSize(new java.awt.Dimension(370, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTitulo.setBackground(new java.awt.Color(0, 129, 255));
        jpTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitulo.setText("Confirmación");
        jpTitulo.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 290, 40));

        jbsalir.setBackground(new java.awt.Color(0, 129, 255));
        jbsalir.setForeground(new java.awt.Color(255, 255, 255));
        jbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/icon/cerrar-w.png"))); // NOI18N
        jbsalir.setBorder(null);
        jbsalir.setBorderPainted(false);
        jbsalir.setContentAreaFilled(false);
        jbsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbsalir.setOpaque(true);
        jbsalir.setRequestFocusEnabled(false);
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        jpTitulo.add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 5, 30, 30));

        jPanel1.add(jpTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 40));

        jpContenido.setBackground(new java.awt.Color(255, 255, 255));
        jpContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 129, 255)));
        jpContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtxtMensaje.setEditable(false);
        jtxtMensaje.setBackground(new java.awt.Color(255, 255, 255));
        jtxtMensaje.setColumns(20);
        jtxtMensaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jtxtMensaje.setLineWrap(true);
        jtxtMensaje.setRows(5);
        jtxtMensaje.setText("¿Esta seguro de realizar esta acción?");
        jtxtMensaje.setWrapStyleWord(true);
        jtxtMensaje.setAutoscrolls(false);
        jtxtMensaje.setBorder(null);
        jScrollPane1.setViewportView(jtxtMensaje);

        jpContenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 20, 280, 50));

        jbtnSi.setBackground(new java.awt.Color(0, 129, 255));
        jbtnSi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSi.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSi.setText("SI");
        jbtnSi.setBorder(null);
        jbtnSi.setBorderPainted(false);
        jbtnSi.setContentAreaFilled(false);
        jbtnSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnSi.setOpaque(true);
        jbtnSi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnSiMouseMoved(evt);
            }
        });
        jbtnSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnSiMouseExited(evt);
            }
        });
        jbtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSiActionPerformed(evt);
            }
        });
        jpContenido.add(jbtnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 70, 35));

        jbtnNo.setBackground(new java.awt.Color(107, 117, 125));
        jbtnNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnNo.setForeground(new java.awt.Color(255, 255, 255));
        jbtnNo.setText("NO");
        jbtnNo.setBorder(null);
        jbtnNo.setBorderPainted(false);
        jbtnNo.setContentAreaFilled(false);
        jbtnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNo.setOpaque(true);
        jbtnNo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnNoMouseMoved(evt);
            }
        });
        jbtnNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnNoMouseExited(evt);
            }
        });
        jbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNoActionPerformed(evt);
            }
        });
        jpContenido.add(jbtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 80, 70, 35));
        jpContenido.add(jlblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 64, 64));

        jPanel1.add(jpContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 370, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        respuesta = NO;
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jbtnSiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSiMouseMoved
        this.jbtnSi.setBackground(new java.awt.Color(45, 151, 254));
    }//GEN-LAST:event_jbtnSiMouseMoved

    private void jbtnSiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSiMouseExited
        this.jbtnSi.setBackground(new java.awt.Color(0, 129, 255));
    }//GEN-LAST:event_jbtnSiMouseExited

    private void jbtnNoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnNoMouseMoved
        this.jbtnNo.setBackground(new java.awt.Color(132, 142, 149));
    }//GEN-LAST:event_jbtnNoMouseMoved

    private void jbtnNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnNoMouseExited
        this.jbtnNo.setBackground(new java.awt.Color(107, 117, 125));
    }//GEN-LAST:event_jbtnNoMouseExited

    private void jbtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSiActionPerformed
        respuesta = SI;
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbtnSiActionPerformed

    private void jbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNoActionPerformed
        respuesta = NO;
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jbtnNoActionPerformed

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
            java.util.logging.Logger.getLogger(DlgWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgWindow dialog = new DlgWindow(new javax.swing.JDialog(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbsalir;
    private javax.swing.JButton jbtnNo;
    private javax.swing.JButton jbtnSi;
    private javax.swing.JLabel jlblIcon;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpTitulo;
    private javax.swing.JTextArea jtxtMensaje;
    // End of variables declaration//GEN-END:variables
}
