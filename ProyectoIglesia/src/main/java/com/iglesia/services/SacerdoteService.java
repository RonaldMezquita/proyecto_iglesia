/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Sacerdote;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import com.iglesia.utils.ProjectUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alexi
 */
public class SacerdoteService extends CrudUtils<Sacerdote> {

    public SacerdoteService() {
        super(Sacerdote.class);
    }

    public List<Sacerdote> buscarSacerdote(String filtro, TipoBusquedaEnum tipo) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<Sacerdote> lista = null;
        try {
            if (tipo.equals(TipoBusquedaEnum.DUI)) {
                lista = this.buscarSacerdotePorDui(em, filtro).getResultList();
            } else if (tipo.equals(TipoBusquedaEnum.NOMBRE)) {
                lista = this.buscarSacerdotePorNombres(em, filtro).getResultList();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
        return lista;
    }

    public Query buscarSacerdotePorDui(EntityManager em, String filtro) {
        Query query = null;
        try {
            // Si la longitud de filtro(DUI) sin guion es menor a 8, se le quita el guion, de lo contrario no se le quita
            filtro = filtro.replace("-", "").trim().length() < 8 ? filtro.replace("-", "").trim() : filtro.trim();
            query = em.createQuery("select t from Sacerdote t where t.dui like :dui")
                    .setParameter("dui", ProjectUtils.fmtLikeBegins(filtro));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return query;
    }

    public Query buscarSacerdotePorNombres(EntityManager em, String filtro) {
        Query query = null;
        try {
            query = em.createQuery("select t from Sacerdote t where CONCAT(t.nombres, ' ', t.apellidos) like :filtro")
                    .setParameter("filtro", ProjectUtils.fmtLikeContain(filtro));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return query;
    }
}
