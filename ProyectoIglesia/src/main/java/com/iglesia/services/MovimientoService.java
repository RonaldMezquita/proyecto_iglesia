/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Movimiento;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ronald Mezquita
 */
public class MovimientoService extends CrudUtils<Movimiento> {

    public MovimientoService() {
        super(Movimiento.class);
    }

    /**
     *
     * @param filtro
     * @param tipo
     * @return
     */
    public List<Movimiento> consultarMovimientos(Object[] filtro, TipoBusquedaEnum tipo) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<Movimiento> lista = null;
        try {
            if (tipo.equals(TipoBusquedaEnum.RANGO_FECHA)) {
                lista = this.movPorRangoFechas(em, filtro).getResultList();
            } else if (tipo.equals(TipoBusquedaEnum.TIPO_MOV)) {
                lista = this.movPorTipo(em, filtro).getResultList();
            } else if (tipo.equals(TipoBusquedaEnum.RANGO_FECHAS_TIPOMOV)) {
                lista = this.movPorRangoFechasYTipo(em, filtro).getResultList();
            }
        } catch (Exception e) {
            System.out.println("[MovimientoService][consultarMovimientos]->excepcion: " + e.getMessage());
        }
        return lista;
    }

    public Query movPorRangoFechas(EntityManager em, Object[] filtros) {
        Query query = null;
        try {
            query = em.createQuery("select t from Movimiento t "
                    + "left join fetch t.idEvento evento "
                    + "left join fetch t.idJustificacion justi "
                    + "where t.fechaMov>=:fechaIni and t.fechaMov<=:fechaFin")
                    .setParameter("fechaIni", (Date) filtros[0])
                    .setParameter("fechaFin", (Date) filtros[1]);
        } catch (Exception e) {
            System.out.println("[MovimientoService][movPorRangoFechas]->Ocurrio un problema para generar la Query");
        }
        return query;
    }

    public Query movPorTipo(EntityManager em, Object[] filtros) {
        Query query = null;
        try {
            query = em.createQuery("select t from Movimiento t "
                    + "left join fetch t.idEvento evento "
                    + "left join fetch t.idJustificacion justi "
                    + "where t.tipo=:tipoMov")
                    .setParameter("tipoMov", filtros[0].toString());
        } catch (Exception e) {
            System.out.println("[MovimientoService][movTipo]->Ocurrio un problema para generar la Query");
        }
        return query;
    }

    public Query movPorRangoFechasYTipo(EntityManager em, Object[] filtros) {
        Query query = null;
        try {
            query = em.createQuery("select t from Movimiento t "
                    + "left join fetch t.idEvento evento "
                    + "left join fetch t.idJustificacion justi "
                    + "where t.fechaMov>=:fechaIni and t.fechaMov<=:fechaFin "
                    + "and t.tipo=:tipoMov")
                    .setParameter("fechaIni", (Date) filtros[0])
                    .setParameter("fechaFin", (Date) filtros[1])
                    .setParameter("tipoMov", filtros[2].toString());
        } catch (Exception e) {
            System.out.println("[MovimientoService][movTipo]->Ocurrio un problema para generar la Query");
        }
        return query;
    }

}
