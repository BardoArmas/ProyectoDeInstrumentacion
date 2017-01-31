/*
Esta clase analisa las tramas de entrada por el puerto para verficicar si son correctas
 */
package com.app.controlador.analisis;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.analizador.Analizador;
import com.app.modelo.conexion.serial.ConexionSerial;
import com.app.modelo.conexion.serial.ConexionSerialImple;
import com.app.modelo.entidades.Parametro;
import com.app.modelo.entidades.Trama;
import com.app.vista.iggrafica.Muestreo;
import com.app.vista.igusuario.Analizando;
import com.app.vista.igusuario.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class AnalizarTramas {

    public void comprobarYConectar(Principal principal, Sesion sesion) {
        // Mostrar la animacion de espera para detectar un flujo incorrecto
        Analizando a = new Analizando();
        a.setVisible(true);
        // Establecer los parametro de la conexion
        int baudios = Integer.valueOf(String.valueOf(principal.getComboBaudios().getSelectedItem()));
        int datos = Integer.valueOf(String.valueOf(principal.getComboDatos().getSelectedItem()));
        int paridad = Integer.valueOf(String.valueOf(principal.getComboParidad().getSelectedIndex()));
        int paro = Integer.valueOf(String.valueOf(principal.getComboParo().getSelectedItem()));
        String puerto = String.valueOf(principal.getComboPuertos().getSelectedItem());
        Parametro parametros = new Parametro(puerto, baudios, datos, paro, paridad);
        //Se establecen los parametros de la conexion a arduino
        System.out.println("Baudios " + baudios + "datos " + datos + "paridad " + paridad + "paro " + paro + " COM " + puerto);
        sesion.setParametros(parametros);
        // Llamar al analizador
//        Analizador analizador = new Analizador();
//        ConexionSerial conexionSerial = new ConexionSerialImple(parametros);
//        double probabilida = 0.0;
//        try {
//            conexionSerial.abrir();
//            Thread.sleep(2000);
//            for (int i = 0; i < 100; i++) {
//                Trama trama = analizador.convertir(conexionSerial.leerMensaje());
//                System.out.println(trama);
//                if (trama.getA() != -1) {
//                    probabilida++;
//                }
//            }
//            a.setVisible(false);
//            a.dispose();
//            probabilida = probabilida / 100.0;
//            System.out.println("Probabilidad " + probabilida);
//            if (probabilida > 0.7) {
//                new Muestreo(sesion, null).setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(a, "Error en el patron de las tramas ", "Tramas no validas", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (SerialPortException ex) {
//            System.err.println("Error al abrir el puerto " + ex);
//            JOptionPane.showMessageDialog(a, "Error al conectar al puerto " + ex, "Error al conectar", JOptionPane.ERROR_MESSAGE);
//            a.setVisible(false);
//            a.dispose();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AnalizarTramas.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
