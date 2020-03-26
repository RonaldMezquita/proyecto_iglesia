/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

/**
 *
 * @author remsf
 */
public class Test {

    public static void main(String[] args) {
//        EntityManager em= PersistenceManager.getEntityManager();
//        em.getTransaction().begin();
//        Usuario u = (Usuario) em.createQuery("select t from Usuario t where t.idUsuario=:usuario")
//                .setParameter("usuario", 1)
//                .getSingleResult();
//        em.getTransaction().commit();
//        System.out.println(u.getNombre());
//        StringBuilder fecha = new StringBuilder("A los ")
//                .append(NumeroALetras.cantidadConLetra("2").toLowerCase()).append("dias del mes de ")
//                .append(FechasUtils.getMonthName(5).toLowerCase()).append(" del año ")
//                .append(NumeroALetras.cantidadConLetra("2020").toLowerCase());
//
//        System.out.println(fecha);
//        Conexion con = new Conexion();
//        try {
//            PreparedStatement ps = con.getConexion().prepareStatement("select * from persona");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("nombres"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }               
//        System.out.println(NumeroALetras.cantidadConLetra("1981"));
        
        String res = NumeroALetras.convertirLetras(1);
        System.out.println(res);
    }
}
