/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.ParseException;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
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

    public static boolean validarVacios(JPanel panel, List<String> excepciones) {
        boolean vacio = false;
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                if (((JTextField) components[i]).getText().isEmpty()) {
                    if (excepciones != null) {
                        if (!excepciones.contains(((JTextField) components[i]).getName())) {
                            System.out.println("Campo vacio " + ((JTextField) components[i]).getName());
                            vacio = true;
                            break;
                        } else {
                            continue;
                        }
                    }
                    System.out.println("Campo vacio " + ((JTextField) components[i]).getName());
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
                    ((JTextArea)((JScrollPane) components[i]).getViewport().getView()).setText("");
                }
            }
            if (components[i] instanceof JDateChooser) {
                ((JDateChooser) components[i]).setDate(null);
            }
        }
    }
    
    public static DefaultTableModel construirModeloTabla(String[] titulo){
        DefaultTableModel model;        
        model = new DefaultTableModel(null, titulo){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }            
        };        
        return model;
    }
    
    /**
     * Elimina las filas de un DefaultTableModel
     * @param model
     * @return 
     */
    public static DefaultTableModel removeRows(DefaultTableModel model){
        int numRows = model.getRowCount();
        for (int i = 0; i < numRows; i++) {            
            model.removeRow(0);
        }
        return model;
    }
    
    private static MaskFormatter mascaraDui(){
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
    
    private static MaskFormatter mascaraNit(){
        MaskFormatter mask = new MaskFormatter();
        try {            
            mask = new MaskFormatter("####-######-###-#");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return mask;
    }
    
    public static JFormattedTextField getCampoDui(){
        return new javax.swing.JFormattedTextField(ProjectUtils.mascaraDui());
    }
    
    public static JFormattedTextField getCampoNit(){
        return new javax.swing.JFormattedTextField(ProjectUtils.mascaraNit());
    }
    
    public static String fmtLike(String param) {
        return new StringBuilder("%").append(param).append("%").toString();
    }
}






