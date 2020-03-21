/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Lugar;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.services.LugarService;
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
 * @author alexi
 */
public class LugarController implements Serializable {

    private Lugar selected;
    private List<Lugar> items;

    private LugarService lugarService;

    public LugarController() {
        this.lugarService = new LugarService();
        this.selected = new Lugar();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }

    public void consultarTodos() {
        this.items = this.lugarService.consultarTodos("select t from Lugar t");
    }

    public Lugar consultarPorId(Integer idLugar) {
        this.selected = this.lugarService.consultarPor("select t from Lugar t where t.id=:id",
                "id", idLugar);
        return this.selected;
    }

    public Lugar crear() {
        if (this.selected == null) {
            System.out.println("LugarController[crear()]-> Objeto Lugar no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.lugarService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("LugarController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Lugar actualizar() {
        if (this.selected == null) {
            System.out.println("LugarController[actualizar()]-> Objeto Lugar no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.lugarService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("LugarController[actualizar()]-> " + e.getMessage());
        }
        return null;
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.lugarService.buscarLugar(filtro);
        String[] datos = new String[3];
        for (Lugar user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
    public void llenarTablaBusqueda(JTable tabla, String filtro, TipoBusquedaEnum tipo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.lugarService.buscarLugar(filtro);
        JButton btn = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/x26-aceptar2_azul.png"), null);
        Object[] datos = new Object[3];
        for (Lugar user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = btn;
            model.addRow(datos);
        }
        tabla.setModel(model);
    }

//    public void buscarLugar(String nombre,JTable tabla) {
//        String[] titulo = {"Id", "Nombre", "Estado"};
//        DefaultTableModel model = ProjectUtils.construirModeloTabla(titulo);
//        model = this.cargarDatos(model, this.lugarService.buscarLugar(nombre));
//        tabla.setModel(model);
//    }
//    private DefaultTableModel cargarDatos(DefaultTableModel model, List<Lugar> items) {
//        String[] datos = new String[3];
//        for (Lugar user : items) {
//            datos[0] = user.getId().toString();
//            datos[1] = user.getNombre();
//            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
//            model.addRow(datos);
//        }
//        return model;
//    }
    //<editor-fold defaultstate="collapsed" desc="getters & setters">    
    public Lugar getSelected() {
        return selected;
    }

    public void setSelected(Lugar selected) {
        this.selected = selected;
    }

    public List<Lugar> getItems() {
        return items;
    }

    public void setItems(List<Lugar> items) {
        this.items = items;
    }

    public LugarService getLugarService() {
        return lugarService;
    }

    public void setLugarService(LugarService lugarService) {
        this.lugarService = lugarService;
    }
    //</editor-fold>

}
