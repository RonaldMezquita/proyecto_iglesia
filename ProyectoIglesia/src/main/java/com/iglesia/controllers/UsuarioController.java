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
@Named
public class UsuarioController implements Serializable{
    
    private Usuario selected;
    private List<Usuario> items;
    @Inject
    private UsuarioService usuarioService;

    public UsuarioController() {
    }
    
    public void consultarTodos(){
        this.items = this.usuarioService.consultarTodos("select t from Usuario t");
    }
    
    public Usuario consultarPorId(Integer idUSuario){
        this.selected = this.usuarioService.consultarPor("select t from Usuario t where t.idUsuario=:idUsuario", 
                "idUsuario", idUSuario);
        return this.selected;
    }
    
    public void crear() throws Exception{
        if(this.selected != null){
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            if(this.usuarioService.crear(this.selected) != null){
                
            }                
        }
    }
    
}






