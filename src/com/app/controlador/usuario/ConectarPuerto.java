/*
Conectar con el puerto serial por medio de la api JSSC
 */
package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.serial.ConexionSerialImple;
import com.app.vista.iggrafica.Muestreo;
import com.app.vista.igusuario.Analizar;
import com.app.vista.igusuario.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class ConectarPuerto {

    public static void hacer(Sesion sesion, Principal principal) {
        try {
            ConexionSerialImple cs = (ConexionSerialImple) sesion.getConexionSerial();
            cs.setParametros(sesion.getParametros());
            cs.abrir();
            principal.setVisible(false);
            Analizar a = new Analizar();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.setVisible(true);
                }
            }).start();
            Thread.sleep(3000);
            a.dispose();
            new Muestreo(sesion, principal).setVisible(true);
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(principal, "Error al comunicar con arduino", "Error en arduino", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al conectar con el puerto serial " + ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConectarPuerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
