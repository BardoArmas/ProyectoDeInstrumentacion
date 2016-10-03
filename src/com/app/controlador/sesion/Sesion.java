/*
Este objeto seguira vivo durante todo la ejecuacion del programa
pasando de vista en vista
 */
package com.app.controlador.sesion;

import com.app.modelo.arduino.ComunicacionArduino;
import com.app.modelo.conexion.Conexion;
import com.app.modelo.entidades.Parametro;
import com.app.modelo.entidades.Usuario;

public class Sesion {
    
    //Contiene los atributos de la session
    private Usuario usuario;
    private Parametro parametros;
    private Conexion mySQL;
    private ComunicacionArduino arduino;

    public Sesion() {
    }

    public Sesion(Usuario usuario, Parametro parametros, Conexion mySQL, ComunicacionArduino arduino) {
        this.usuario = usuario;
        this.parametros = parametros;
        this.mySQL = mySQL;
        this.arduino = arduino;
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

    public Conexion getMySQL() {
        return mySQL;
    }

    public void setMySQL(Conexion mySQL) {
        this.mySQL = mySQL;
    }

    public ComunicacionArduino getArduino() {
        return arduino;
    }

    public void setArduino(ComunicacionArduino arduino) {
        this.arduino = arduino;
    }
    
    
    
    public void terminarSesion(){
        //Invalidar la sesion para iniciar de nuevo
        usuario = null;
    }
    
}
