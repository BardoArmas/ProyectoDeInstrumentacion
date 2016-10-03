/*
Implementacion de la interfaz
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
    private final String SQL_INSERT = "insert into reporte (idUsuario,nombre,descripcion,fecha,xy1,xy2,xy3,datos) values (?,?,?,NOW(),?,?,?,?)";
    private final String SQL_SELECT_MUESTRA = "select xy1,xy2,xy3,datos from reporte where idMuestra = ? and idUsuario = ?";

    @Override
    public List<Muestra> todoPorUsuario(Connection connection, int idUsuario) {
        List<Muestra> muestras = new ArrayList<>();
        try {
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
        } catch (SQLException ex) {
            System.err.println("Error en la conexion para sacar las muestras por usuario " + ex);
        }
        return muestras;
    }

    @Override
    public boolean crear(Muestra muestra, Connection connection) {
        boolean estado = false;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, muestra.getIdUsuario());
            ps.setString(2, muestra.getNombre());
            ps.setString(3, muestra.getDescripcion());
            //Guardar en bytes el objeto demasiado grande
            ps.setBytes(4, convertir(muestra.getXy1()));
            ps.setBytes(5, convertir(muestra.getXy2()));
            ps.setBytes(6, convertir(muestra.getXy3()));
            ps.setBytes(6, convertir(muestra.getDatosSerial()));
            //ejecutar el insert
            ps.executeUpdate();
            estado = true;
        } catch (SQLException ex) {
            System.err.println("Error al conectar " + ex);
        } catch (IOException ex) {
            System.err.println("Error al crear object output stream " + ex);
        }
        return estado;
    }

    @Override
    public boolean todasMuestras(Connection connection, Muestra muestra) {
        boolean estado = false;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_MUESTRA);
            ps.setInt(1, muestra.getIdMuestra());
            ps.setInt(2, muestra.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Se obtiene el campo blob
                muestra.setXy1(invertir(rs.getBlob("xy1")));
                muestra.setXy2(invertir(rs.getBlob("xy2")));
                muestra.setXy3(invertir(rs.getBlob("xy3")));
                muestra.setDatosSerial(invertirS(rs.getBlob("datos")));
            }
            estado = true;
        } catch (SQLException ex) {
            System.err.println("Error en la conexion para sacar las muestras por usuario " + ex);
        } catch (IOException ex) {
            System.err.println("Error al crear el objeto input stream " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al aplicar el cast en todoPorUsuari " + ex);
        }
        return estado;
    }

    private byte[] convertir(Integer[][] xy) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArray);
        oos.writeObject(xy);
        return byteArray.toByteArray();
    }
    
    private byte[] convertir(String datos) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArray);
        oos.writeObject(datos);
        return byteArray.toByteArray();
    }

    private Integer[][] invertir(Blob blob) throws IOException, ClassNotFoundException, SQLException {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        return (Integer[][]) ois.readObject();
    }
    
    private String invertirS(Blob blob) throws IOException, ClassNotFoundException, SQLException {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        return (String) ois.readObject();
    }

}
