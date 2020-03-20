/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Alexis
 */
public class Conexion {

    private final String url = "jdbc:mysql://localhost:3306/db_iglesia";
    private final String user = "root";
    private final String password = "rems87";
    private Connection con;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);            
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, nulln ex
        }
        return con;
    }
}
