/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import com.iglesia.utils.PersistenceManager;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 * @param <T>
 */
public abstract class CrudUtils<T> {

    private final Class<T> entityClass;

    public CrudUtils(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * @param <T>
     * @param entity
     * @return
     * @throws Exception
     */
    public <T> T crear(T entity) throws Exception {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(entity);            
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }finally{
            em.close();
        }
    }
}




