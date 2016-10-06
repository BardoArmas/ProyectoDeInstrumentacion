/*
Conexion Serial usando JSSC para el puerto serial
 */
package com.app.modelo.conexion.serial;

import com.app.modelo.entidades.Parametro;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ConexionCOM {

    private SerialPort serialPort;
    private Parametro parametros;

    public ConexionCOM(Parametro parametros) {
        this.parametros = parametros;
    }

    public boolean abrirPuerto() {
        try {
            //Hacer conexion al puerto COM
            serialPort = new SerialPort(parametros.getPuerto());
            serialPort.openPort();
            serialPort.setParams(parametros.getBaudios(), parametros.getDato(), parametros.getParo(), parametros.getParidad());
            return true;
        } catch (SerialPortException ex) {
            System.err.println("Error en conectar al puerto " + ex);
            return false;
        }
    }

    public void escribirMensaje(String mensaje) {
        try {
            serialPort.writeBytes(mensaje.getBytes());
        } catch (SerialPortException ex) {
            System.err.println("Error al escribir mensaje " + ex);
        }
    }
    
    public String leerMensaje() throws SerialPortException{
        return new String(serialPort.readBytes());
    }

    public boolean cerrarPuerto() {
        try {
            serialPort.closePort();
            return true;
        } catch (SerialPortException ex) {
            System.err.println("Error al desconectar " + ex);
            return false;
        }
    }

    public boolean estaAbierto() {
        return serialPort != null;
    }

    public static Object[] puertosDisponibles() {
        return SerialPortList.getPortNames();
    }
}
