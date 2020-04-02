/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.services.SacerdoteService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.RenderCellTable;
import java.io.Serializable;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class SacerdoteController implements Serializable {

    private Sacerdote selected;
    private List<Sacerdote> items;
    private SacerdoteService sacerdoteService;

    public SacerdoteController() {
        this.sacerdoteService = new SacerdoteService();
        this.selected = new Sacerdote();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }

    public void consultarTodos() {
        this.items = this.sacerdoteService.consultarTodos("select t from Sacerdote t");
    }

    public Sacerdote consultarPorId(Integer id) {
        this.selected = this.sacerdoteService.consultarPor("select t from Sacerdote t where t.id=:id",
                "id", id);
        return this.selected;
    }

    public Sacerdote crear() {
        if (this.selected == null) {
            System.out.println("SacerdoteController[crear()]-> objeto Sacerdote no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.sacerdoteService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("SacerdoteController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Sacerdote actualizar() {
        if (this.selected == null) {
            System.out.println("SacerdoteController[actualizar()]-> objeto Sacerdote no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.sacerdoteService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("SacerdoteController[actualizar()]-> " + e.getMessage());
        }
        return null;
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.sacerdoteService.buscarSacerdote(filtro, TipoBusquedaEnum.NOMBRE);
        String[] datos = new String[7];
        for (Sacerdote item : this.getItems()) {
            datos[0] = item.getId().toString();
            datos[1] = item.getNombres();
            datos[2] = item.getApellidos();
            datos[3] = item.getDui();
            datos[4] = item.getNit();
            datos[5] = item.getParroco() ? "Parroco" : "N/A";
            datos[6] = item.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }

    public void llenarTablaBusqueda(JTable tabla, String filtro, TipoBusquedaEnum tipo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.sacerdoteService.buscarSacerdote(filtro.trim(), tipo);
        JButton btn = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/seleccionar.png"), null);
        Object[] datos = new Object[4];
        for (Sacerdote item : this.getItems()) {
            datos[0] = item.getId().toString();
            datos[1] = item.getNombreCompleto();
            datos[2] = item.getDui();
            datos[3] = btn;
            model.addRow(datos);
        }
        tabla.setModel(model);
    }

//<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Sacerdote getSelected() {
        return selected;
    }

    public void setSelected(Sacerdote selected) {
        this.selected = selected;
    }

    public List<Sacerdote> getItems() {
        return items;
    }

    public void setItems(List<Sacerdote> items) {
        this.items = items;
    }

    public SacerdoteService getSacerdoteService() {
        return sacerdoteService;
    }

    public void setSacerdoteService(SacerdoteService sacerdoteService) {
        this.sacerdoteService = sacerdoteService;
    }
    //</editor-fold>

}
