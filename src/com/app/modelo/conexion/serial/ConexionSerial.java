/*
Interfaz de conexion serial
 */
package com.app.modelo.conexion.serial;

import com.app.vista.iggrafica.Muestreo;
import jssc.SerialPortException;

public interface ConexionSerial {


    public void cerrar() throws SerialPortException;

    public void escribirMensaje(String mensaje) throws SerialPortException;

    public String leerMensaje() throws SerialPortException;

    public boolean estaAbierto();

    public void abrir(Muestreo muestreo) throws SerialPortException;

}
