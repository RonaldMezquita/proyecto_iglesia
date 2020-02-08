/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author remsf
 */
public class PersistenceManager {
    private static EntityManagerFactory entityManagerFactory= null;
    
    private PersistenceManager(){}
    
    public static EntityManager getEntityManager(){
        if (entityManagerFactory != null) {
            return entityManagerFactory.createEntityManager();
        }        
        return getEntityManagerFactory().createEntityManager();
    }
    
    
    private static synchronized EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("iglesia_pu");
        }
        return entityManagerFactory;
    }
}
