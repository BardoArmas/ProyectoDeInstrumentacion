package com.app.modelo.conexion.serial;

import com.app.modelo.entidades.Parametro;
import com.app.vista.iggrafica.Muestreo;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ConexionSerialImple implements ConexionSerial {

    private SerialPort serialPort;
    private Parametro parametros;
    private String mensaje;
    private String mensajeAux;

    public ConexionSerialImple() {
        this.mensaje = "";
        this.mensajeAux = "";
    }

    public ConexionSerialImple(Parametro parametros) {
        this.parametros = parametros;
        this.mensaje = "";
        this.mensajeAux = "";
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    @Override
    public void abrir(Muestreo muestreo) throws SerialPortException {
        //Hacer conexion al puerto COM
        mensajeAux = "";
        serialPort = new SerialPort(parametros.getPuerto());
        serialPort.openPort();
        serialPort.setParams(parametros.getBaudios(), parametros.getDato(), parametros.getParo(), parametros.getParidad());
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
        serialPort.addEventListener(muestreo, SerialPort.MASK_RXCHAR);
    }

    @Override
    public void cerrar() throws SerialPortException {
        serialPort.closePort();
    }

    @Override
    public void escribirMensaje(String mensaje) throws SerialPortException {
        serialPort.writeBytes(mensaje.getBytes());
    }

    @Override
    public String leerMensaje() throws SerialPortException {
        mensajeAux = mensaje;
        mensaje = "";
        return mensajeAux;
    }

    @Override
    public boolean estaAbierto() {
        return serialPort != null;
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public static Object[] puertosDisponibles() {
        return SerialPortList.getPortNames();
    }

}
