/*
Interfaz de conexion serial
 */
package com.app.modelo.conexion.serial;

import jssc.SerialPortException;

public interface ConexionSerial {

    public void abrir() throws SerialPortException;
    
    public void cerrar() throws SerialPortException;

    public void escribirMensaje(String mensaje) throws SerialPortException;

    public String leerMensaje() throws SerialPortException;

    public boolean estaAbierto();
    
}
