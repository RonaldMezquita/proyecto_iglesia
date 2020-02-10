/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Usuario;
import com.iglesia.services.UsuarioService;
import com.iglesia.utils.FechasUtils;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

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

    public Usuario crear(){
        if (this.selected != null) {
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.usuarioService.crear(this.selected) != null) {
                    return this.selected;
                }
            } catch (Exception e) {
                System.out.println("UsuarioController[crear()]-> "+e.getMessage());
            }
        }
        return null;
    }

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

}



