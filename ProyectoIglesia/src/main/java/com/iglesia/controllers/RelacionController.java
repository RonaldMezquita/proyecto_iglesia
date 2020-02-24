/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Relacion;
import com.iglesia.entities.Usuario;
import com.iglesia.services.RelacionService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import java.io.Serializable;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexi
 */
public class RelacionController implements Serializable {

    private Relacion selected;
    private List<Relacion> items;

    private RelacionService relacionService;

    public RelacionController() {
        this.relacionService = new RelacionService();
        this.selected = new Relacion();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }

    public void consultarTodos() {
        this.items = this.relacionService.consultarTodos("select t from Relacion t");
    }

    public Relacion consultarPorId(Integer idRelacion) {
        this.selected = this.relacionService.consultarPor("select t from Relacion t where t.idRelacion=:idRelacion",
                "idRelacion", idRelacion);
        return this.selected;
    }

    public Relacion crear() {
        if (this.selected == null) {
            System.out.println("RelacionController[crear()]-> objeto Relacion no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.relacionService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("RelacionController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Relacion actualizar() {
        if (this.selected == null) {
            System.out.println("RelacionController[actualizar()]-> objeto Relacion no existe");
            return null;
        }
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.relacionService.actualizar(this.selected) != null) {
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
        this.items = this.relacionService.buscarRelacion(filtro);
        String[] datos = new String[3];
        for (Relacion user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">    
    public Relacion getSelected() {
        return selected;
    }

    public void setSelected(Relacion selected) {
        this.selected = selected;
    }

    public List<Relacion> getItems() {
        return items;
    }

    public void setItems(List<Relacion> items) {
        this.items = items;
    }

    public RelacionService getRelacionService() {
        return relacionService;
    }

    public void setRelacionService(RelacionService relacionService) {
        this.relacionService = relacionService;
    }
    //</editor-fold>

}
