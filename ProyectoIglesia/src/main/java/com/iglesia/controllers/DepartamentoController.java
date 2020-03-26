/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Departamento;
import com.iglesia.services.DepartamentoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Ronald Mezquita
 */
public class DepartamentoController implements Serializable {

    private Departamento selected;
    private List<Departamento> items;
    private DepartamentoService departamentoService;

    public DepartamentoController() {
        this.selected = new Departamento();
        this.departamentoService = new DepartamentoService();
        this.items = new ArrayList<>();
    }

    public void consultarTodos() {
        this.items = this.departamentoService.consultarTodos("select t from Departamento t "
                + "inner join fetch t.idPais pais");
    }

    public void getCombobox(JComboBox<Departamento> cbDepto) {
        this.consultarTodos();
        Departamento sec = new Departamento();
        sec.setNombre("*** Seleccione ***");
        cbDepto.addItem(sec);
        for (Departamento item : this.items) {
            cbDepto.addItem(item);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Departamento getSelected() {
        return selected;
    }

    public void setSelected(Departamento selected) {
        this.selected = selected;
    }

    public List<Departamento> getItems() {
        return items;
    }

    public void setItems(List<Departamento> items) {
        this.items = items;
    }
    //</editor-fold>

}
