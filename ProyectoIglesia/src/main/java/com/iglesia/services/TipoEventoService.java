/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.TipoEvento;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alexis
 */
public class TipoEventoService extends CrudUtils<TipoEvento>{

    public TipoEventoService() {
        super(TipoEvento.class);
    }
    public List<TipoEvento> buscarTipoEvento(String filtro) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<TipoEvento> lista = null;
        try {
            lista = em.createQuery("select t from TipoEvento t where t.nombre like :nombre")
                    .setParameter("nombre", "%" + filtro + "%")
                    .getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            PersistenceManager.close();
        }
        return lista;
    }
}
