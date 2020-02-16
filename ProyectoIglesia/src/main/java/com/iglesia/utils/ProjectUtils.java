/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
}






