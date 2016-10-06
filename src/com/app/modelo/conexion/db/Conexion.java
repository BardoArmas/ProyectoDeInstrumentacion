/*
Objeto de conexion para mysql
 */
package com.app.modelo.conexion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/proyecto_instrumentacion";
    private final String root  = "root";
    private final String pass  = "avecias";
    private Connection conexion;
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, root, pass);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver no encontrado " + ex);
        } catch (SQLException ex) {
            System.err.println("Conexion no extablecida " + ex);
        }
        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
