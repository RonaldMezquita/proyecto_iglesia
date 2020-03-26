/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Pais;
import com.iglesia.services.PaisService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald Mezquita
 */
public class PaisController implements Serializable {

    private Pais selected;
    private List<Pais> items;
    private PaisService paisService;

    public PaisController() {
        this.selected = new Pais();
        this.paisService = new PaisService();
        this.items = new ArrayList<>();
    }

    public void consultarTodos() {
        this.items = this.paisService.consultarTodos("select t from Pais t");
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Pais getSelected() {
        return selected;
    }

    public void setSelected(Pais selected) {
        this.selected = selected;
    }

    public List<Pais> getItems() {
        return items;
    }

    public void setItems(List<Pais> items) {
        this.items = items;
    }
    //</editor-fold>

}
