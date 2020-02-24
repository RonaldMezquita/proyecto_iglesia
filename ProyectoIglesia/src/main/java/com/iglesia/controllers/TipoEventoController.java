/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.TipoEvento;
import com.iglesia.services.TipoEventoService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import java.io.Serializable;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class TipoEventoController implements Serializable {
    private TipoEvento selected;
    private List<TipoEvento> items;

    private TipoEventoService tipoEventoService;

    public TipoEventoController() {
        this.selected = new TipoEvento();
        this.tipoEventoService = new TipoEventoService();
        
    }
    

    public void consultarTodos() {
        this.items = this.tipoEventoService.consultarTodos("select t from TipoEvento t");
    }

    public TipoEvento consultarPorId(Integer idTipoEvento) {
        this.selected = this.tipoEventoService.consultarPor("select t from TipoEvento t where t.id=:id",
                "id", idTipoEvento);
        return this.selected;
    }
    public TipoEvento crear() {
        if (this.selected == null) {
            System.out.println("TipoEventoController[crear()]-> Objeto TipoEvento no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.tipoEventoService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("TipoEventoController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public TipoEvento actualizar() {
        if (this.selected == null) {
            System.out.println("TipoEventoController[actualizar()]-> Objeto TipoEvento no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.tipoEventoService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("TipoEventoController[actualizar()]-> " + e.getMessage());
        }
        return null;
    }
    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.tipoEventoService.buscarTipoEvento(filtro);        
        String[] datos = new String[3];
        for (TipoEvento user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
//<editor-fold defaultstate="collapsed" desc="getters & setters">
    public TipoEvento getSelected() {
        return selected;
    }

    public void setSelected(TipoEvento selected) {
        this.selected = selected;
    }

    public List<TipoEvento> getItems() {
        return items;
    }

    public void setItems(List<TipoEvento> items) {
        this.items = items;
    }

    public TipoEventoService getTipoEventoService() {
        return tipoEventoService;
    }

    public void setTipoEventoService(TipoEventoService tipoEventoService) {
        this.tipoEventoService = tipoEventoService;
    }
    //</editor-fold>
    
    
}
