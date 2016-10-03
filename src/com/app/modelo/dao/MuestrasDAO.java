
package com.app.modelo.dao;

import com.app.modelo.entidades.Muestra;
import java.sql.Connection;
import java.util.List;

interface MuestrasDAO {
    
    public List<Muestra> todoPorUsuario(Connection connection,int idUsuario);
    
    public boolean crear(Muestra muestra,Connection connection);
    
    public boolean todasMuestras(Connection connection,Muestra muestra);
}
