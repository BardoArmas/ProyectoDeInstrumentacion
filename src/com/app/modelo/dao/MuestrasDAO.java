package com.app.modelo.dao;

import com.app.modelo.entidades.Muestra;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

interface MuestrasDAO {

    public List<Muestra> todoPorUsuario(Connection connection, int idUsuario) throws SQLException;

    public void crear(Muestra muestra, Connection connection) throws SQLException, IOException;

    public void todasMuestras(Connection connection, Muestra muestra) throws IOException, ClassNotFoundException, SQLException;
}
