/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Lugar;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alexi
 */
public class LugarService extends CrudUtils<Lugar> {

    public LugarService() {
        super(Lugar.class);
    }

    public List<Lugar> buscarLugar(String nombre) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<Lugar> lista = null;
        try {
            lista = em.createQuery("select t from Lugar t where t.nombre like :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
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
