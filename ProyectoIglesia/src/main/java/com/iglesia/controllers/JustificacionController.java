/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Justificacion;
import com.iglesia.services.JustificacionService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import java.io.Serializable;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class JustificacionController implements Serializable {
    
    private Justificacion selected;
    private List<Justificacion> items;
    
    private JustificacionService justificacionService;
    
    public JustificacionController() {
        this.justificacionService = new JustificacionService();
        this.selected = new Justificacion();
        this.selected.setEstado(true);
    }
    
    public void consultarTodos() {
        this.items = this.justificacionService.consultarTodos("select t from Justificacion t");
    }
    
    public Justificacion consultarPorId(Integer idJustificacion) {
        this.selected = this.justificacionService.consultarPor("select t from Justificacion t where t.id=:id",
                "id", idJustificacion);
        return this.selected;
    }
    
    public Justificacion crear() {
        if (this.selected == null) {
            System.out.println("RelacionController[crear()]-> Objeto Justificacion no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.justificacionService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("RelacionController[crear()]-> " + e.getMessage());
        }
        
        return null;
    }
    
    public Justificacion actualizar() {
        if (this.selected == null) {
            System.out.println("RelacionController[actualizar()]-> Objeto Justificacion no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.justificacionService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("RelacionController[actualizar()]-> " + e.getMessage());
        }
        return null;
    }
    
    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.justificacionService.buscarJustificacion(filtro);
        String[] datos = new String[3];
        for (Justificacion user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
    
    public void getComboBox(JComboBox<Justificacion> combo) {
        this.consultarTodos();
        Justificacion seleccionar = new Justificacion(null, "*** Seleccione ***", true, null);
        combo.addItem(seleccionar);        
        for (Justificacion item : this.items) {
            combo.addItem(item);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">   
    public Justificacion getSelected() {
        return selected;
    }
    
    public void setSelected(Justificacion selected) {
        this.selected = selected;
    }
    
    public List<Justificacion> getItems() {
        return items;
    }
    
    public void setItems(List<Justificacion> items) {
        this.items = items;
    }
    
    public JustificacionService getJustificacionService() {
        return justificacionService;
    }
    
    public void setJustificacionService(JustificacionService justificacionService) {
        this.justificacionService = justificacionService;
    }
    //</editor-fold>

}
