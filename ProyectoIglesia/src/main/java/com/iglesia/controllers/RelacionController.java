/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Relacion;
import com.iglesia.services.RelacionService;
import com.iglesia.utils.FechasUtils;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alexi
 */
public class RelacionController implements Serializable{
    private Relacion selected;
    private List<Relacion> items;
    
    private RelacionService relacionService;

    public RelacionController() {
        this.relacionService = new RelacionService();
        this.selected = new Relacion();
        this.selected.setEstado(true);
    }

    public void consultarTodos() {
        this.items = this.relacionService.consultarTodos("select t from Relacion t");
    }

    public Relacion consultarPorId(Integer idRelacion) {
        this.selected = this.relacionService.consultarPor("select t from Relacion t where t.idRelacion=:idRelacion",
                "idRelacion", idRelacion);
        return this.selected;
    }

    public Relacion crear(){
        if (this.selected != null) {
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.relacionService.crear(this.selected) != null) {
                    return this.selected;
                }
            } catch (Exception e) {
                System.out.println("RelacionController[crear()]-> "+e.getMessage());
            }
        }
        return null;
    }
    public Relacion actualizar(){
        if (this.selected != null) {
            this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
            try {
                if (this.relacionService.actualizar(this.selected) != null) {
                    return this.selected;
                }
            } catch (Exception e) {
                System.out.println("RelacionController[actualizar()]-> "+e.getMessage());
            }
        }
        return null;
    }
}



