
package com.app.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Muestra implements Serializable{
    
    private int idMuestra;
    private int idUsuario;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Integer[][] sensor1;
    private Integer[][] sensor2;
    private Integer[][] sensor3;
    private String datosSerial;

    public Muestra() {
    }

    public Muestra(int idMuestra, int idUsuario, String nombre, String descripcion, Date fecha, Integer[][] sensor1, Integer[][] sensor2, Integer[][] sensor3, String datosSerial) {
        this.idMuestra = idMuestra;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.datosSerial = datosSerial;
    }

    public Muestra(int idMuestra, int idUsuario) {
        this.idMuestra = idMuestra;
        this.idUsuario = idUsuario;
    }

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer[][] getSensor1() {
        return sensor1;
    }

    public void setSensor1(Integer[][] sensor1) {
        this.sensor1 = sensor1;
    }

    public Integer[][] getSensor2() {
        return sensor2;
    }

    public void setSensor2(Integer[][] sensor2) {
        this.sensor2 = sensor2;
    }

    public Integer[][] getSensor3() {
        return sensor3;
    }

    public void setSensor3(Integer[][] sensor3) {
        this.sensor3 = sensor3;
    }

    public String getDatosSerial() {
        return datosSerial;
    }

    public void setDatosSerial(String datosSerial) {
        this.datosSerial = datosSerial;
    }
    

    @Override
    public String toString() {
        return "Muestra{" + "idMuestra=" + idMuestra + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
    
}
