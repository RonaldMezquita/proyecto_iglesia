/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author alexi
 */
public class ProjectUtils {
    
    private static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    private static final DecimalFormat fmtMoneda = new DecimalFormat("###,###,###.00");
    
    public static boolean validarVacios(JPanel panel, List<String> excepciones) {
        boolean vacio = false;
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                if (((JTextField) components[i]).getText().isEmpty()) {
                    if (excepciones != null) {
                        if (!excepciones.contains(((JTextField) components[i]).getName())) {
                            System.out.println("Campo tipo texto vacio " + ((JTextField) components[i]).getName());
                            vacio = true;
                            break;
                        } else {
                            continue;
                        }
                    }
                    System.out.println("Campo tipo texto vacio " + ((JTextField) components[i]).getName());
                    vacio = true;
                    break;
                }
            } else if (components[i] instanceof JDateChooser) {
                if (((JDateChooser) components[i]).getDate() == null) {
                    if (excepciones != null) {
                        if (!excepciones.contains(((JDateChooser) components[i]).getName())) {
                            System.out.println("Campo tipo fecha vacio " + ((JDateChooser) components[i]).getName());
                            vacio = true;
                            break;
                        } else {
                            continue;
                        }
                    }
                    System.out.println("Campo tipo fecha vacio " + ((JDateChooser) components[i]).getName());
                    vacio = true;
                    break;
                }
            }
        }
        return vacio;
    }
    
    public static void limpiarComponentes(JPanel panel) {
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                ((JTextField) components[i]).setText("");
            }
            if (components[i] instanceof JCheckBox) {
                ((JCheckBox) components[i]).setSelected(false);
            }
            if (components[i] instanceof JScrollPane) {
                if (((JScrollPane) components[i]).getViewport().getView() instanceof JTextArea) {
                    ((JTextArea) ((JScrollPane) components[i]).getViewport().getView()).setText("");
                }
            }
            if (components[i] instanceof JDateChooser) {
                ((JDateChooser) components[i]).setDate(null);
            }
            
            if (components[i] instanceof JComboBox) {
                ((JComboBox) components[i]).setSelectedItem(((JComboBox) components[i]).getItemAt(0));
            }
        }
    }
    
    public static DefaultTableModel construirModeloTabla(String[] titulo) {
        DefaultTableModel model;
        model = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }

    /**
     * Elimina las filas de un DefaultTableModel
     *
     * @param model
     * @return
     */
    public static DefaultTableModel removeRows(DefaultTableModel model) {
        int numRows = model.getRowCount();
        for (int i = 0; i < numRows; i++) {
            model.removeRow(0);
        }
        return model;
    }
    
    private static MaskFormatter mascaraDui() {
        MaskFormatter mask = new MaskFormatter();
        try {
            /*
            # -> un numero
            U -> letra mayuscula
            L -> letra minuscula
            * -> cualquier caracter
            ' -> caracter de escape
            A -> cualquier letra o numero
            ? -> cualquier caracter
            H -> cualquier caracter hexagonal [0-9, a-f, A-F]            
             */
            mask = new MaskFormatter("########-#");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return mask;
    }
    
    private static MaskFormatter mascaraNit() {
        MaskFormatter mask = new MaskFormatter();
        try {
            mask = new MaskFormatter("####-######-###-#");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return mask;
    }
    
    public static JFormattedTextField getCampoDui() {
        return new javax.swing.JFormattedTextField(ProjectUtils.mascaraDui());
    }
    
    public static JFormattedTextField getCampoNit() {
        return new javax.swing.JFormattedTextField(ProjectUtils.mascaraNit());
    }
    
    public static String fmtLikeContain(String param) {
        return new StringBuilder("%").append(param).append("%").toString();
    }
    
    public static String fmtLikeBegins(String param) {
        return new StringBuilder(param).append("%").toString();
    }
    
    public static String fmtLikeEnds(String param) {
        return new StringBuilder("%").append(param).toString();
    }
    
    public static JButton getButton(URL url, String tooltip) {
        ImageIcon img = new ImageIcon(url);
        //int ancho = 25; // ancho en pixeles que tendra el icono escalado
        //int alto = 25;//-1; // alto (para que conserve la proporcion pasamos -1)

        // Obtiene un icono en escala con las dimensiones especificadas        
        //ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        JButton btn = new JButton();
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (tooltip != null) {
            btn.setToolTipText(tooltip);
        }
        btn.setIcon(img);
        return btn;
    }
    
    public static String formatearFecha(Date fecha) {
        return fmt.format(fecha);
    }
    
    public static String formatearMoneda(BigDecimal monto) {
        return fmtMoneda.format(monto.doubleValue());
    }

    /**
     * Metodo que coloca subrayado al texto de un JLabel
     *
     * @param label
     */
    public static void setUnderline(JLabel label) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }
}
