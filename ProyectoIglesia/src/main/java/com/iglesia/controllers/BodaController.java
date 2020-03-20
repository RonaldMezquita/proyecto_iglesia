/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.dtos.BodaDto;
import com.iglesia.utils.FechasUtils;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class BodaController {

    private BodaDto selected;
    private List<BodaDto> items;

    public BodaController() {
        this.selected = new BodaDto();
        this.selected.setFecha(FechasUtils.getCurrentDate());
    }

    //<editor-fold defaultstate="collapsed" desc="getters & settes">
    public BodaDto getSelected() {
        return selected;
    }

    public void setSelected(BodaDto selected) {
        this.selected = selected;
    }

    public List<BodaDto> getItems() {
        return items;
    }

    public void setItems(List<BodaDto> items) {
        this.items = items;
    }
    //</editor-fold>

}
