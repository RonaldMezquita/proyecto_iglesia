/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author remsf
 */
public class CustomComboBox extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent combo) {
        return new CustomComboBox();
    }

    @Override
    protected JButton createArrowButton() {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(this.getClass().getResource("/META-INF/images/icon/minimizar.png")));
        btn.setBorder(BorderFactory.createLineBorder(new java.awt.Color(107, 117, 125)));
        btn.setContentAreaFilled(false);
        return btn;
    }

//    @Override
//    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
//        g.setColor(new java.awt.Color(107, 117, 125));
//        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
//    }[55,71,79]

    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                list.setSelectionBackground(new java.awt.Color(107, 117, 125));
                return this;
            }            
        };
    }

    
}
