/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Evento;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alexi
 */
public class EventoService extends CrudUtils<Evento> {

    public EventoService() {
        super(Evento.class);
    }

    public List<Evento> buscarEvento(Object filtro, Object filtro2, TipoBusquedaEnum tipo) {
        EntityManager em = PersistenceManager.getEntityManager();
        List<Evento> lista = null;
        em.getTransaction().begin();
        try {
            if (tipo.equals(TipoBusquedaEnum.FECHA)) {
                lista = this.buscarEventoFecha(em, filtro).getResultList();
            } else if (tipo.equals(TipoBusquedaEnum.RANGO_FECHA)) {
                lista=this.buscarEventoRangoFecha(em, filtro, filtro2).getResultList();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            PersistenceManager.close();
        }
        return lista;
    }

    public Query buscarEventoFecha(EntityManager em, Object filto) {
        Query sql = null;
        try {
            sql = em.createQuery("select t from Evento t "
                    + "inner join fetch t.idLugar lugar "
                    + "inner join fetch t.idTipoSacramento ts "
                    + "inner join fetch t.idSacerdote tsac "
                    + "inner join fetch t.idUsuario tu "
                    + "where t.fecha=:fecha").setParameter("fecha", (Date) filto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sql;
    }

    public Query buscarEventoRangoFecha(EntityManager em, Object fechaInicio, Object fechaFin) {
        Query sql = null;
        try {
            sql = em.createQuery("select t from Evento t "
                    + "inner join fetch t.idLugar lugar "
                    + "inner join fetch t.idTipoSacramento ts "
                    + "inner join fetch t.idSacerdote tsac "
                    + "inner join fetch t.idUsuario tu "
                    + "where t.fecha>=:fechaInicio and t.fecha<=:fechaFin")
                    .setParameter("fechaInicio", (Date) fechaInicio)
                    .setParameter("fechaFin", (Date) fechaFin);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sql;
    }
}
