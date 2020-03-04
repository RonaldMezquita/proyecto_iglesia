/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Usuario;
import com.iglesia.entities.Sector;
import com.iglesia.services.SectorService;
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
public class SectorController implements Serializable{
    private Sector selected;
    private List<Sector> items;
    private SectorService sectorService;


    public SectorController() {
        this.sectorService = new SectorService();
        this.selected = new Sector();        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }
    public void consultarTodos() {
        this.items = this.sectorService.consultarTodos("select t from Sector t");
    }

    public Sector consultarPorId(Integer idLugar) {
        this.selected = this.sectorService.consultarPor("select t from Sector t where t.id=:id",
                "id", idLugar);
        return this.selected;
    }

    public Sector crear() {
        if (this.selected == null) {
            System.out.println("sectorService[crear()]-> Objeto Sector no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.sectorService.crear(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("sectorService[crear()]-> " + e.getMessage());
        }
        return null;
    }

    public Sector actualizar() {
        if (this.selected == null) {
            System.out.println("sectorService[actualizar()]-> Objeto Sector no existe");
            return null;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.sectorService.actualizar(this.selected) != null) {
                return this.selected;
            }
        } catch (Exception e) {
            System.out.println("sectorService[actualizar()]-> " + e.getMessage());
        }
        return null;
    }

    public void llenarTabla(JTable tabla, String filtro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.sectorService.buscarSector(filtro);
        String[] datos = new String[3];
        for (Sector user : this.getItems()) {
            datos[0] = user.getId().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }
    public void getCombobox(JComboBox<Sector> cbSector){
        this.consultarTodos();
        Sector sec = new Sector();
        sec.setNombre("*** Seleccione ***");
        cbSector.addItem(sec);
        for (Sector item:this.items) {
            cbSector.addItem(item);            
        }
    }
    //<editor-fold defaultstate="collapsed" desc="getters & setters">

    public Sector getSelected() {
        return selected;
    }

    public void setSelected(Sector selected) {
        this.selected = selected;
    }

    public List<Sector> getItems() {
        return items;
    }

    public void setItems(List<Sector> items) {
        this.items = items;
    }

    public SectorService getSectorService() {
        return sectorService;
    }

    public void setSectorService(SectorService sectorService) {
        this.sectorService = sectorService;
    }
    //</editor-fold>
}
