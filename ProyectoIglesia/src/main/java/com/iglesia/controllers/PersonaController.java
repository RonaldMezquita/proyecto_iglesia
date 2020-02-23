/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Persona;
import com.iglesia.entities.Usuario;
import com.iglesia.services.PersonaService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
        this.selected = new Persona();
        this.selected.setEstado(true);
    }

    public void consultarTodos() {
        this.items = this.personaService.consultarTodos("select t from Persona t");
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.personaService.buscarPersona(filtro);
        String[] row = new String[8];
        for (Persona item : this.items) {
            row[0] = item.getId().toString();
            row[1] = item.getNombres();
            row[2] = item.getApellidos();
            row[3] = item.getDui();
            row[4] = item.getNit();
            row[5] = this.sdf.format(item.getFechaNacimiento());
            row[6] = item.getDireccion();
            row[7] = item.getEstado() ? "Activo" : "Inactivo";
            model.addRow(row);
        }
    }

    public Persona crear() {
        if (this.selected == null) {
            System.out.println("PersonaController[crear()]-> Objeto persona no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        this.selected.setIdUsuario(new Usuario(1));
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
        if (this.selected != null) {
            System.out.println("PersonaController[actualizar()]-> Objeto persona no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        this.selected.setIdUsuario(new Usuario(1));
        try {
            if (this.personaService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("PersonaController[actualizar()]-> " + e.getMessage());
        }
        return null;
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
