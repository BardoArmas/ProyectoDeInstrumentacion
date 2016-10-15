/*
Hilo que controla lo eventos de la comunicacion para ser mostrados en la pantalla
 */
package com.app.controlador.muestreo;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.conexion.serial.ConexionSerial;
import com.app.modelo.dialpanel.BarrasPanel;
import com.app.modelo.dialpanel.DialPanel;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jssc.SerialPortException;

public class MostrarComunicacion extends Thread{
    
    private final JTextArea areaTexto;
    private boolean iniciar;
    private final Sesion sesion;
    private DialPanel dialPanel;
    private BarrasPanel barrasPanel;
    private final JPanel panelChart, panelDatosEntrada;
    private ValidarTrama validarTrama;
    //Double valorA,valorB,valorC;
    double [] resultado ;

    public MostrarComunicacion(JTextArea areaTexto, Sesion sesion, JPanel panelChart, JPanel panelDatosEntrada) {
        this.areaTexto = areaTexto;
        this.sesion = sesion;
        this.panelChart = panelChart;
        this.panelDatosEntrada = panelDatosEntrada;
        iniciar = true;
    }

    @Override
    public void run() {
        //Inicia el hilo de la lectura la mostrar los resultados en casi tiempo real
        //Sacar el objeto arduino de la sesion, no es necesario se puede omitir
        validarTrama = new ValidarTrama();
        ConexionSerial cs = sesion.getConexionSerial();
        dialPanel = new DialPanel();
        barrasPanel = new BarrasPanel();
        //panelDial.setPreferredSize(new Dimension(300, 200));
        
        panelChart.removeAll();
        panelChart.repaint();
        panelChart.setLayout(new BorderLayout());
        panelChart.add(dialPanel.crearChart());
        panelChart.validate();
        
        //Chart de barras de datos de entrada
        panelDatosEntrada.removeAll();
        panelDatosEntrada.repaint();
        panelDatosEntrada.setLayout(new BorderLayout());
        panelDatosEntrada.add(barrasPanel.crearChart());
        panelDatosEntrada.validate();
                
        while (iniciar) {
            try {
                //Inicia la lectura en la jareatext
                String trama = cs.leerMensaje();
                areaTexto.append( trama + "\n");
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
                resultado = validarTrama.hacer(trama);
                dialPanel.getDataset().setValue(resultado[0]);
                barrasPanel.escribirValor(resultado[0], resultado[1], resultado[2]);
//            panel2.getDataset().setValue(resultado[1]);
//            panel3.getDataset().setValue(resultado[2]);
            } catch (SerialPortException ex) {
                System.err.println("Error al leer " + ex);
            }
        }
    }
    
    public void detener(){
        iniciar = false;
    }
    
}
