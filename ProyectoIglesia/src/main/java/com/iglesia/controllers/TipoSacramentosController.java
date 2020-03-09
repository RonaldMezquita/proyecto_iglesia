/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.TipoSacramentos;
import com.iglesia.services.TipoSacramentosService;
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
public class TipoSacramentosController implements Serializable {
    private TipoSacramentos selected;
    private List<TipoSacramentos> items;

    private TipoSacramentosService tipoSacramentosService;

    public TipoSacramentosController() {
        this.selected = new TipoSacramentos();
        this.tipoSacramentosService = new TipoSacramentosService();
        
    }
    

    public void consultarTodos() {
        this.items = this.tipoSacramentosService.consultarTodos("select t from TipoSacramentos t");
    }

    public TipoSacramentos consultarPorId(Integer idTipoEvento) {
        this.selected = this.tipoSacramentosService.consultarPor("select t from TipoSacramentos t where t.id=:id",
                "id", idTipoEvento);
        return this.selected;
    }
    public TipoSacramentos crear() {
        if (this.selected == null) {
            System.out.println("TipoEventoController[crear()]-> Objeto TipoSacramentos no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.tipoSacramentosService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("TipoEventoController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public TipoSacramentos actualizar() {
        if (this.selected == null) {
            System.out.println("TipoEventoController[actualizar()]-> Objeto TipoSacramentos no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.tipoSacramentosService.actualizar(this.selected) != null) {
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
        this.items = this.tipoSacramentosService.buscarTipoEvento(filtro);        
        String[] datos = new String[3];
        for (TipoSacramentos user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
//<editor-fold defaultstate="collapsed" desc="getters & setters">
    public TipoSacramentos getSelected() {
        return selected;
    }

    public void setSelected(TipoSacramentos selected) {
        this.selected = selected;
    }

    public List<TipoSacramentos> getItems() {
        return items;
    }

    public void setItems(List<TipoSacramentos> items) {
        this.items = items;
    }

    public TipoSacramentosService getTipoEventoService() {
        return tipoSacramentosService;
    }

    public void setTipoEventoService(TipoSacramentosService tipoEventoService) {
        this.tipoSacramentosService = tipoEventoService;
    }
    //</editor-fold>
    
    
}
