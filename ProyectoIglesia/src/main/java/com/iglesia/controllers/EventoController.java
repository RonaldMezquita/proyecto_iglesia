/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Evento;
import com.iglesia.entities.Usuario;
import com.iglesia.services.EventoService;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author remsf
 */
public class EventoController implements Serializable {

    private Evento selected;
    private List<Evento> items;
    private EventoService eventoService;

    public EventoController() {
        this.eventoService = new EventoService();
        this.selected = new Evento();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
    }

    public void consultarTodos() {
        this.items = this.eventoService.consultarTodos("select t from Evento t"
                + "inner join fetch t.idLugar lug "
                + "inner join fetch t.idSacerdote sac "
                + "inner join fetch t.idTipoSacramento tipoSacramento "
                + "inner join fetch t.idUsuario usu ");
    }

    public Evento consultarPorId(Integer id) {
        this.selected = this.eventoService.consultarPor("select t from Evento t "
                + "inner join fetch t.idLugar lug "
                + "inner join fetch t.idSacerdote sac "
                + "inner join fetch t.idTipoSacramento tipoSacramento "
                + "inner join fetch t.idUsuario usu "
                + "where t.id=:id",
                "id", id);
        return this.selected;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Evento getSelected() {
        return selected;
    }

    public void setSelected(Evento selected) {
        this.selected = selected;
    }

    public List<Evento> getItems() {
        return items;
    }

    public void setItems(List<Evento> items) {
        this.items = items;
    }
    //</editor-fold>
    
}
