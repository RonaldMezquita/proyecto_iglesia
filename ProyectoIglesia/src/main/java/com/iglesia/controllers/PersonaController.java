/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Persona;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.services.PersonaService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.RenderCellTable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author remsf
 */
public class PersonaController {

    private List<Persona> items = new ArrayList<>();
    private Persona selected;
    private PersonaService personaService;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public PersonaController() {
        this.personaService = new PersonaService();
        this.prepararCrear();
    }

    public void prepararCrear() {
        this.selected = new Persona();
        this.selected.setEstado(true);
    }

    public void consultarTodos() {
        this.items = this.personaService.consultarTodos("select t from Persona t "
                + "inner join fetch t.idDepartamento depto ");
    }

    public Persona consultarPorId(Integer idPersona) {
        this.selected = this.personaService.consultarPor("select t from Persona t "
                + "inner join fetch t.idDepartamento depto "
                + "where t.id=:id",
                "id", idPersona);
        return this.selected;
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.personaService.buscarPersona(filtro.trim(), TipoBusquedaEnum.NOMBRE);
        JButton btn = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/editar_black.png"), null);
        Object[] row = new Object[10];
        for (Persona item : this.items) {
            row[0] = item.getId().toString();
            row[1] = item.getNombres();
            row[2] = item.getApellidos();
            row[3] = item.getDui();
            row[4] = item.getNit();
            row[5] = this.sdf.format(item.getFechaNacimiento());
            row[6] = item.getDireccion();
            row[7] = item.getGenero();
            row[8] = item.getEstado() ? "Activo" : "Inactivo";
            row[9] = btn;
            model.addRow(row);
        }
    }

    public void llenarTablaBusqueda(JTable tabla, String filtro, TipoBusquedaEnum tipo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.personaService.buscarPersona(filtro.trim(), tipo);
        JButton btn = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/seleccionar.png"), null);
        Object[] row = new Object[5];
        for (Persona item : this.items) {
            row[0] = item.getId().toString();
            row[1] = item.getNombres();
            row[2] = item.getApellidos();
            row[3] = item.getDui();
            row[4] = btn;
            model.addRow(row);
        }
    }

    public Persona crear() {
        if (this.selected == null) {
            System.out.println("PersonaController[crear()]-> Objeto persona no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.personaService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("PersonaController[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Persona actualizar() {
        if (this.selected == null) {
            System.out.println("PersonaController[actualizar()]-> Objeto persona no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.personaService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("PersonaController[actualizar()]-> " + e.getMessage());
        }
        return null;
    }

    public void getCombobox(JComboBox<Persona> cbSector) {
        this.consultarTodos();
        Persona per = new Persona();
        per.setNombres("*** Seleccione ***");
        per.setApellidos("");
        cbSector.addItem(per);
        for (Persona item : this.items) {
            cbSector.addItem(item);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public List<Persona> getItems() {
        return items;
    }

    public void setItems(List<Persona> items) {
        this.items = items;
    }

    public Persona getSelected() {
        return selected;
    }

    public void setSelected(Persona selected) {
        this.selected = selected;
    }
    //</editor-fold>
}
