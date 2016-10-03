
package com.app.modelo.dao;

import com.app.modelo.entidades.Usuario;
import java.sql.Connection;
import java.util.List;

interface UsuarioDAO {
    
    public Usuario buscar(Usuario usuario, Connection connection);
    
    public boolean actualizar(Usuario usuario, Connection connection);
    
    public boolean borrar(Usuario usuario, Connection connection);
    
    public boolean crear(Usuario usuario, Connection connection);
    
    public List<Usuario> todos(Connection connection);
    
}
