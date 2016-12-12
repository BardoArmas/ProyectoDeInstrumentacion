package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.db.ConexionSQL;
import com.app.modelo.dao.MuestraDAOImple;
import com.app.modelo.entidades.Muestra;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BuscarMuestrasParaGraficar {

    public void graficar(Sesion sesion) {
        try {
            //Usuario usuario = sesion.getUsuario();
            ConexionSQL mySQL = sesion.getConexionSQL();
            Muestra muestra = new Muestra();
            new MuestraDAOImple().todasMuestras(mySQL.getConexion(), muestra);
            JOptionPane.showMessageDialog(null, "No se pudo encontrar las muestras");
            Integer[][] xy = muestra.getSensor1();
            for (int i = 0; i < xy.length; i++) {
                //Sacar los valores y mapearlos
            }
        } catch (NullPointerException e) {
            //Error al rescatar al usario subido a sesion
            System.err.println("Error al bajar de la session al usuario o la  conexion" + e);
        } catch (SQLException ex) {
            System.err.println("Error al conectar " + ex);
        } catch (IOException ex) {
            System.err.println("Error al crear object output stream " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Convercion no exitosa " + ex);
        }
    }
}
