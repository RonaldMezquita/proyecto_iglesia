/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.ResponsableEvento;
import com.iglesia.services.ResponsableEventoService;
import com.iglesia.utils.ProjectUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class ResponsableEventoController implements Serializable {

    private ResponsableEvento selected;
    private List<ResponsableEvento> items;
    private ResponsableEventoService responsableEventoService;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ResponsableEventoController() {
        this.selected = new ResponsableEvento();
        this.responsableEventoService = new ResponsableEventoService();
    }

    public void consultarReponsablesPorEvento(Integer idEvento) {
        this.items = this.responsableEventoService.getDetalleEvento(idEvento);
    }

    public void llenarTabla(JTable tabla, Integer filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.consultarReponsablesPorEvento(filtro);
        String[] row = new String[8];
        for (ResponsableEvento item : this.items) {
            row[0] = item.getId().toString();
            row[1] = item.getIdPersona().getNombreCompleto();
            row[2] = item.getIdRelacion().getNombre();
            row[3] = item.getIdPadre() != null ? item.getIdPadre().getNombreCompleto() : "";
            row[4] = item.getIdMadre() != null ? item.getIdMadre().getNombreCompleto() : "";
            row[5] = this.sdf.format(item.getIdEvento().getFecha());
            model.addRow(row);
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">

    public ResponsableEvento getSelected() {
        return selected;
    }

    public void setSelected(ResponsableEvento selected) {
        this.selected = selected;
    }

    public List<ResponsableEvento> getItems() {
        return items;
    }

    public void setItems(List<ResponsableEvento> items) {
        this.items = items;
    }
    //</editor-fold>

}
