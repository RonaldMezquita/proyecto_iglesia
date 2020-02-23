/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Sacerdote;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alexi
 */
public class SacerdoteService extends CrudUtils<Sacerdote>{

    public SacerdoteService() {
        super(Sacerdote.class);
    }
    public List<Sacerdote> buscarSacerdote(String filtro) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<Sacerdote> lista = null;
        try {
            lista = em.createQuery("select t from Sacerdote t where t.nombres like :nombres")
                    .setParameter("nombres", "%" + filtro + "%")
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


