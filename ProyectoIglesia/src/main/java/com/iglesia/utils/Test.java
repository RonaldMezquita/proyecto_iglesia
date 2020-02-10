/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import com.iglesia.entities.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author remsf
 */
public class Test {
    public static void main(String[] args) {
        EntityManager em= PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        Usuario u = (Usuario) em.createQuery("select t from Usuario t where t.idUsuario=:usuario")
                .setParameter("usuario", 1)
                .getSingleResult();
        em.getTransaction().commit();
        System.out.println(u.getNombre());
    }
}


