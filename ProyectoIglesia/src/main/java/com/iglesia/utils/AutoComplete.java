/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import java.lang.reflect.Method;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Clase para generar JList de autocomplete de tipo Object
 *
 * @author Ronald Mezquita
 */
public class AutoComplete {

    private JList<Object> lista;
    private JScrollPane jsPanel;
    private JTextField text;
    private DefaultListModel model;
    private Object selected;
    private String metodoName;

    private AutoComplete() {
        this.lista = new JList<>();
        this.model = new DefaultListModel();
    }

    /**
     * Contructor
     *
     * @param textField Campo de texto al cual se le va a asignar el
     * autocompletar
     * @param selected
     */
    public AutoComplete(JTextField textField, String metodoName) {
        this();
        this.text = textField;
        this.metodoName = metodoName;
        this.initJScrollPanel();
        this.jsPanel.setVisible(false);
    }

    /**
     * Metodo para generar la inicializacion del componente JScrollPane y
     * asignarle el objeto JList
     */
    private void initJScrollPanel() {
        this.jsPanel = new JScrollPane();
        jsPanel.setBorder(null);
        jsPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        jsPanel.setViewportView(lista);
        this.text.getParent().add(this.jsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 96, 290, 90));
    }

    /**
     * Metodo que se va a ejecutar cuando se haga click sobre un elemento de la
     * lista
     *
     * @param evt
     */
    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {
        this.selected = this.lista.getSelectedValue();
        this.text.setText(lista.getSelectedValue().toString());
        this.lista.setVisible(false);
    }

    /**
     * Metodo para agregar elementos al modelo asignado al objeto JList
     *
     * @param element
     */
    public void addElement(Object element) {
        this.model.addElement(element);
    }

    /**
     * Metodo para setear modelo al objeto JList
     *
     * @param model
     */
    public void setModel(DefaultListModel model) {
        this.model = model;
        this.lista.setModel(this.model);
    }

    public Object getSelected() {
        return selected;
    }

    /**
     * Metodo para realizar el filtro de los elementos del objeto JList segun lo
     * digitado en el JTexField asignado
     */
    public void filterListItems() {
        DefaultListModel filterModel = new DefaultListModel();
        boolean visible = false;
        if (this.text.getText().trim().equals("")) {
            this.lista.setVisible(visible);
            return;
        }
        int modelSize = this.model.size();
        try {
            for (int i = 0; i < modelSize; i++) {
                Object texto = this.model.get(i);
                Method[] metodos = texto.getClass().getMethods();
                for (int j = 0; j < metodos.length; j++) {
                    if (metodos[j].getName().startsWith(this.metodoName)) {
                        String valor = texto.getClass().getMethod(metodos[j].getName(), null).invoke(texto, null).toString();
                        if (valor.toLowerCase().contains(this.text.getText().trim().toLowerCase())) {
                            filterModel.addElement(model.get(i));
                            visible = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[AutoComplete]->[filterListItems]->ex= " + e.getMessage());
        }

        this.lista.setVisible(visible);
        this.jsPanel.setBounds((this.text.getX() + 2), (this.text.getHeight() + this.text.getY()), 250, (20 * filterModel.size()));
        this.lista.setModel(filterModel);
        this.jsPanel.setVisible(true);
    }

}
