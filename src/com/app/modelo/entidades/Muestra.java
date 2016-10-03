
package com.app.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Muestra implements Serializable{
    
    private int idMuestra;
    private int idUsuario;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Integer[][] xy1;
    private Integer[][] xy2;
    private Integer[][] xy3;
    private String datosSerial;

    public Muestra() {
    }

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
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

    public Integer[][] getXy1() {
        return xy1;
    }

    public void setXy1(Integer[][] xy1) {
        this.xy1 = xy1;
    }

    public Integer[][] getXy2() {
        return xy2;
    }

    public void setXy2(Integer[][] xy2) {
        this.xy2 = xy2;
    }

    public Integer[][] getXy3() {
        return xy3;
    }

    public void setXy3(Integer[][] xy3) {
        this.xy3 = xy3;
    }

    public String getDatosSerial() {
        return datosSerial;
    }

    public void setDatosSerial(String datosSerial) {
        this.datosSerial = datosSerial;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Muestra{" + "idMuestra=" + idMuestra + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
    
}
