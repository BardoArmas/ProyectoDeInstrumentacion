
package com.app.modelo.arduino;

import com.app.modelo.entidades.Parametro;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.List;
import panamahitek.Arduino.PanamaHitek_Arduino;

public class ComunicacionArduino {
    
    
    PanamaHitek_Arduino ardu = new PanamaHitek_Arduino();
    
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            //Solo tiene un evento para sobrecargar
        }
    };
    
    public boolean comunicarRXTX(Parametro parametro) {
        boolean estado = false;
        try {
            ardu.arduinoRXTX(parametro.getPuerto(), parametro.getBaudios(), evento);
            System.out.println("Comunicacion exitosa ");
            estado = true;
        } catch (Exception e1) {
            System.out.println("Error en la comunicacion " + e1);
        }
        return estado;
    }

    public void terminar() throws Exception {
        ardu.killArduinoConnection();
    }

    public List<String> puertos() {
        return ardu.getSerialPorts();
    }
    
    public String leerMensaje(){
        String mensaje = "";
        while(true){
            mensaje = ardu.printMessage();
            if(!"No hay datos disponibles".equals(mensaje)){
                break;
            }
        }
        return mensaje;
    }
  
    public static void main(String[] args) throws Exception {
        ComunicacionArduino arduino = new ComunicacionArduino();
        arduino.comunicarRXTX(new Parametro("COM3", 8, 9600, 0, 0));
        int t = 0;
        while(t<1000){
            System.out.println(arduino.leerMensaje());
            t++;
        }
        System.out.println("Finalizar");
        arduino.terminar();
    }
}
