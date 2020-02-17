/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Usuario;
import com.iglesia.services.UsuarioService;
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
public class UsuarioController implements Serializable {

    private Usuario selected;
    private List<Usuario> items;

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
        this.selected = new Usuario();
        this.selected.setEstado(true);
    }

    public void consultarTodos() {
        this.items = this.usuarioService.consultarTodos("select t from Usuario t");
    }

    public Usuario consultarPorId(Integer idUSuario) {
        this.selected = this.usuarioService.consultarPor("select t from Usuario t where t.idUsuario=:idUsuario",
                "idUsuario", idUSuario);
        return this.selected;
    }

    public Usuario crear() {
        if (this.selected != null) {
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.usuarioService.crear(this.selected) != null) {
                    return this.selected;
                }
            } catch (Exception e) {
                System.out.println("UsuarioController[crear()]-> " + e.getMessage());
            }
        }
        return null;
    }

    public Usuario actualizar() {
        if (this.selected != null) {
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.usuarioService.actualizar(this.selected) != null) {
                    return this.selected;
                }
            } catch (Exception e) {
                System.out.println("UsuarioController[actualizar()]-> " + e.getMessage());
            }
        }
        return null;
    }

    public void llenarTabla(JTable tabla, String filtro) {        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model = ProjectUtils.removeRows(model);
        this.items = this.usuarioService.buscarUsuario(filtro);
        String[] datos = new String[5];
        for (Usuario user : this.getItems()) {
            datos[0] = user.getIdUsuario().toString();
            datos[1] = user.getNombre();
            datos[2] = user.getApellido();
            datos[3] = user.getUsuario();
            datos[4] = user.getEstado() ? "Activo" : "Inactivo";
            model.addRow(datos);
        }
        tabla.setModel(model);
    }   

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    public List<Usuario> getItems() {
        return items;
    }

    public void setItems(List<Usuario> items) {
        this.items = items;
    }
    //</editor-fold>

}

