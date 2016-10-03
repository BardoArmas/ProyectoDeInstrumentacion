/*
Implementa la interfaz para poder manipular los usuarios
 */
package com.app.modelo.dao;

import com.app.modelo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAOImple implements UsuarioDAO{
    
    private final String SQL_SELECT = "select * from usuario where nickUsuario = ? and contrasenia = ? ";

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public Usuario buscar(Usuario usuario, Connection connection) {
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT);
            ps.setString(1, usuario.getNickUsuario());
            ps.setString(2, usuario.getContrasenia());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPaterno(rs.getString("paterno"));
                usuario.setMaterno(rs.getString("materno"));
                usuario.setCorreo(rs.getString("email"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error al buscar al usuario " + ex);
        }
        return usuario;
    }

    @Override
    public boolean actualizar(Usuario usuario, Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Usuario usuario, Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Usuario usuario, Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> todos(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
