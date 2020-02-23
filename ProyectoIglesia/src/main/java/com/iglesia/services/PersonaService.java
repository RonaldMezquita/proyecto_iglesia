/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Persona;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import com.iglesia.utils.ProjectUtils;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alexi
 */
public class PersonaService extends CrudUtils<Persona> {

    public PersonaService() {
        super(Persona.class);
    }

    public List<Persona> buscarPersona(String filtro) {
        EntityManager em = PersistenceManager.getEntityManager();
        List<Persona> personasLst = null;
        em.getTransaction().begin();
        try {
            personasLst = em.createQuery("select t from Persona t where t.nombres like :filtro or t.apellidos like :filtro")
                    .setParameter("filtro", ProjectUtils.fmtLike(filtro))
                    .getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
        return personasLst;
    }
}
