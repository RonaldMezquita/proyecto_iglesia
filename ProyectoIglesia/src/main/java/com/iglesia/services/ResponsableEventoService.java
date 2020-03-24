/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Evento;
import com.iglesia.entities.ResponsableEvento;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alexi
 */
public class ResponsableEventoService extends CrudUtils<ResponsableEvento> {

    public ResponsableEventoService() {
        super(ResponsableEvento.class);
    }

    public List<ResponsableEvento> getDetalleEvento(Integer idEvento) {
        EntityManager em = PersistenceManager.getEntityManager();
        List<ResponsableEvento> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createQuery("select t from ResponsableEvento t "
                    + "inner join fetch t.idRelacion rel "
                    + "inner join fetch t.idPersona per "
                    + "left join fetch t.idPadre padre "
                    + "left join fetch t.idMadre madre "
                    + "inner join fetch t.idEvento ev "
                    + "inner join fetch ev.idTipoSacramento tsac "
                    + "inner join fetch ev.idSacerdote sac"
                    + "inner join fetch t.idUsuario us "
                    + "where ev.id=:idEvento")
                    .setParameter("idEvento", idEvento).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {
            PersistenceManager.close();
        }
        return lista;
    }
    
    /**
     * Registra los eventos
     * @param evento
     * @param det
     * @return 
     */
    public boolean registrarEvento(Evento evento, List<ResponsableEvento> det){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        boolean result = false;
        try {
            em.persist(evento);
            
            for (ResponsableEvento item : det) {
                item.setIdEvento(evento);
                em.persist(item);
            }
            
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return result;
    }

}
