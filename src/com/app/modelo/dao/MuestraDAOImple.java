/*
Implementacion de la interfaz para visualizar las muestras
 */
package com.app.modelo.dao;

import com.app.modelo.entidades.Muestra;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuestraDAOImple implements MuestrasDAO {

    private final String SQL_SELECT_ALL_BY_USER = "select idReporte,nombre,descripcion,fecha from reporte where idUsuario = ?";
    private final String SQL_INSERT = "insert into reporte (idUsuario,nombre,descripcion,fecha,sensor1,sensor2,sensor3,datos) values (?,?,?,NOW(),?,?,?,?)";
    private final String SQL_SELECT_MUESTRA = "select sensor1,sensor2,sensor3,datos from reporte where idMuestra = ? and idUsuario = ?";

    @Override
    public List<Muestra> todoPorUsuario(Connection connection, int idUsuario) throws SQLException {
        List<Muestra> muestras = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL_BY_USER);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Muestra m = new Muestra();
            m.setIdMuestra(rs.getInt("idMuestra"));
            m.setNombre(rs.getString("nombre"));
            m.setIdUsuario(idUsuario);
            m.setDescripcion(rs.getString("descripcion"));
            m.setFecha(rs.getDate("fecha"));
            muestras.add(m);
        }
        return muestras;
    }

    @Override
    public void crear(Muestra muestra, Connection connection) throws SQLException, IOException {
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
        ps.setInt(1, muestra.getIdUsuario());
        ps.setString(2, muestra.getNombre());
        ps.setString(3, muestra.getDescripcion());
        //Guardar en bytes el objeto demasiado grande
        ps.setBytes(4, convertirValor(muestra.getSensor1()));
        ps.setBytes(5, convertirValor(muestra.getSensor2()));
        ps.setBytes(6, convertirValor(muestra.getSensor3()));
        ps.setBytes(6, convertirTramas(muestra.getDatosSerial()));
        //ejecutar el insert
        ps.executeUpdate();
    }

    @Override
    public void todasMuestras(Connection connection, Muestra muestra) throws SQLException, IOException, ClassNotFoundException {
        PreparedStatement ps = connection.prepareStatement(SQL_SELECT_MUESTRA);
        ps.setInt(1, muestra.getIdMuestra());
        ps.setInt(2, muestra.getIdUsuario());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Se obtiene el campo blob
            muestra.setSensor1(invertirValor(rs.getBlob("sensor1")));
            muestra.setSensor2(invertirValor(rs.getBlob("sensor2")));
            muestra.setSensor3(invertirValor(rs.getBlob("sensor3")));
            muestra.setDatosSerial(invertirTramas(rs.getBlob("datos")));
        }
    }

    private byte[] convertirValor(Integer[][] sensor) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArray);
        oos.writeObject(sensor);
        return byteArray.toByteArray();
    }

    private byte[] convertirTramas(String datos) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArray);
        oos.writeObject(datos);
        return byteArray.toByteArray();
    }

    private Integer[][] invertirValor(Blob blob) throws IOException, SQLException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        return (Integer[][]) ois.readObject();
    }

    private String invertirTramas(Blob blob) throws IOException, SQLException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        return (String) ois.readObject();
    }

}
