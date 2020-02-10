/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import java.util.List;
import java.util.logging.Logger;
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
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }finally{
            PersistenceManager.close();
        }
    }
    public <T> T actualizar(T entity) throws Exception{
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        try{
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }finally{
            PersistenceManager.close();
        }
    }
    
    public List<T> consultarTodos(String jpql){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<T> lista = null;
        try{
           lista = em.createQuery(jpql).getResultList();
           em.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return lista;
    }
    public <T> T consultarPor(String jpql, String parameterName, Integer parameterValue){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        T object = null;
        try{
           object= (T) em.createQuery(jpql)
                   .setParameter(parameterName, parameterValue)
                   .getSingleResult();
           em.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return object;
    }
    public <T> T consultarPor(String jpql, String parameterName, String parameterValue){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        T object = null;
        try{
           object= (T) em.createQuery(jpql)
                   .setParameter(parameterName, parameterValue)
                   .getSingleResult();
           em.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return object;
    }
    
    public List<T> consultarTodosPor(String jpql, String parameterName, Integer parameterValue){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<T> lista = null;
        try{
           lista=  em.createQuery(jpql)
                   .setParameter(parameterName, parameterValue)
                   .getResultList();
           em.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return lista;
    }
    
    public List<T> consultarTodosPor(String jpql, String parameterName, String parameterValue){
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<T> lista = null;
        try{
           lista=  em.createQuery(jpql)
                   .setParameter(parameterName, parameterValue)
                   .getResultList();
           em.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            PersistenceManager.close();
        }
        return lista;
    }
}














