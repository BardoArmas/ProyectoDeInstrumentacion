/*
Este objeto seguira vivo durante todo la ejecuacion del programa
pasando de vista en vista
 */
package com.app.controlador.sesion;

import com.app.modelo.conexion.db.ConexionSQL;
import com.app.modelo.conexion.serial.ConexionSerial;
import com.app.modelo.entidades.Parametro;
import com.app.modelo.entidades.Usuario;

public class Sesion {
    
    //Contiene los atributos de la session
    private Usuario usuario;
    private Parametro parametros;
    private ConexionSQL conexionSQL;
    private ConexionSerial conexionSerial;

    public Sesion() {
    }

    public Sesion(Usuario usuario, Parametro parametros, ConexionSQL conexionSQL, ConexionSerial conexionSerial) {
        this.usuario = usuario;
        this.parametros = parametros;
        this.conexionSQL = conexionSQL;
        this.conexionSerial = conexionSerial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    public ConexionSQL getConexionSQL() {
        return conexionSQL;
    }

    public void setConexionSQL(ConexionSQL conexionSQL) {
        this.conexionSQL = conexionSQL;
    }

    public ConexionSerial getConexionSerial() {
        return conexionSerial;
    }

    public void setConexionSerial(ConexionSerial conexionSerial) {
        this.conexionSerial = conexionSerial;
    }

    public void terminarSesion(){
        //Invalidar la sesion para iniciar de nuevo
        usuario = null;
    }
    
}
