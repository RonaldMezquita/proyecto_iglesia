/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Usuario;
import com.iglesia.utils.CrudUtils;
import com.iglesia.utils.PersistenceManager;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alexi
 */
public class UsuarioService extends CrudUtils<Usuario> {

    public UsuarioService() {
        super(Usuario.class);
    }

    public List<Usuario> buscarUsuario(String filtro) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        List<Usuario> lista = null;
        try {
            lista = em.createQuery("select t from Usuario t where t.nombre like :filtro or t.apellido like :filtro")
                    .setParameter("filtro", "%" + filtro + "%")
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

    public Usuario comprobarUsuario(Usuario usuario) {
        EntityManager em = PersistenceManager.getEntityManager();
        em.getTransaction().begin();
        Usuario user = null;
        try {
            user = (Usuario) em.createQuery("select t from Usuario t where t.estado=1 and "
                    + "t.usuario=:usuario and t.clave=:clave")
                    .setParameter("usuario", usuario.getUsuario())
                    .setParameter("clave", usuario.getClave())
                    .getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("[UsuarioService][comprobarUsuario]->Exection => " + e.getMessage());
            em.getTransaction().rollback();
        }
        return user;
    }

}
