/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Comunidad;
import com.iglesia.entities.Usuario;
import com.iglesia.services.ComunidadService;
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
public class ComunidadController implements Serializable {

    private Comunidad selected;
    private List<Comunidad> items;
    private ComunidadService comunidadService;

    public ComunidadController() {
        this.comunidadService = new ComunidadService();
        this.selected = new Comunidad();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }
    public void consultarTodos() {
        this.items = this.comunidadService.consultarTodos("select t from Comunidad t");
    }

    public Comunidad consultarPorId(Integer idLugar) {
        this.selected = this.comunidadService.consultarPor("select t from Comunidad t where t.id=:id",
                "id", idLugar);
        return this.selected;
    }

    public Comunidad crear() {
        if (this.selected == null) {
            System.out.println("comunidadService[crear()]-> Objeto Comunidad no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.comunidadService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("comunidadService[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Comunidad actualizar() {
        if (this.selected == null) {
            System.out.println("comunidadService[actualizar()]-> Objeto Comunidad no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.comunidadService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("comunidadService[actualizar()]-> " + e.getMessage());
        }
        return null;
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.comunidadService.buscarComunidad(filtro.trim());
        Object[] datos = new Object[4];
        for (Comunidad user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getIdSector();
            datos[3] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">

    public Comunidad getSelected() {
        return selected;
    }

    public void setSelected(Comunidad selected) {
        this.selected = selected;
    }

    public List<Comunidad> getItems() {
        return items;
    }

    public void setItems(List<Comunidad> items) {
        this.items = items;
    }

    public ComunidadService getComunidadService() {
        return comunidadService;
    }

    public void setComunidadService(ComunidadService comunidadService) {
        this.comunidadService = comunidadService;
    }
    //</editor-fold>
    
}
