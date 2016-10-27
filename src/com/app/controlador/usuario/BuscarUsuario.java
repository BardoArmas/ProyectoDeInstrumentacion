/*
Dedicado solo a buscar el usuario para poder leerlo
 */
package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.db.ConexionSQL;
import com.app.modelo.dao.UsuarioDAOImple;
import com.app.modelo.entidades.Usuario;
import com.app.vista.igusuario.Login;
import com.app.vista.igusuario.Principal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BuscarUsuario {

    public void get(Sesion sesion, Login login) {
        try {
            Usuario usuario = sesion.getUsuario();
            ConexionSQL mySQL = sesion.getConexionSQL();
            usuario = new UsuarioDAOImple().buscar(usuario, mySQL.getConexion());
            if (usuario.getNombre().equals("")) {
                JOptionPane.showMessageDialog(login, "No se encontro el usuario: usuario no valido");
                login.getTextoUsuario().setText("");
                login.getTextoContrasenia().setText("");
                login.getTextoUsuario().requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(null, "Bienvenido \n" + usuario.nombreCompleto());
                //Se pasa la sesion para serguir con los mismos datos
                login.setVisible(false);
                login.dispose();
                sesion.setUsuario(usuario);
                new Principal(sesion).setVisible(true);
            }
        } catch (NullPointerException e) {
            //Error al rescatar al usario subido a sesion
            System.err.println("Error al bajar de la session al usuario o la  conexion" + e);
        }
    }
}
