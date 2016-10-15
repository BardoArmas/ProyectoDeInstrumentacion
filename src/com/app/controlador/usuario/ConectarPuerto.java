/*
Conectar con el puerto serial por medio de la api JSSC
 */
package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.serial.ConexionSerial;
import com.app.modelo.conexion.serial.ConexionSerialImple;
import com.app.vista.ig.Muestreo;
import com.app.vista.ig.Principal;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class ConectarPuerto {

    public static void hacer(Sesion sesion, Principal principal) {
        try {
            ConexionSerialImple cs = (ConexionSerialImple) sesion.getConexionSerial();
            cs.setParametros(sesion.getParametros());
            cs.abrir();
            new Muestreo(sesion, principal).setVisible(true);
            principal.setVisible(false);
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(principal, "Error al comunicar con arduino", "Error en arduino", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al conectar con el puerto serial " + ex);
        }
    }
}
