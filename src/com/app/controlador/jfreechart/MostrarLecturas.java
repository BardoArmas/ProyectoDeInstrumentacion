/*
Muestra las lecturas que se van registrando en el arduino de los tres sensores
en casi tiempo real
 */
package com.app.controlador.jfreechart;

import com.app.controlador.sesion.Sesion;

public class MostrarLecturas extends Thread{
    
    private String nombre;
    private String descripcion;
    private final Sesion sesion;
    private boolean bandera;
    
    public MostrarLecturas(Sesion sesion){
        this.sesion = sesion;
    }
    
    @Override
    public void run() {
        //Inicia la lectura desde el puerto en el arduino
        sesion.getUsuario();
        while(bandera){
            //Inicia el muestreo de los sensores
        }
        //Se detiene el muestreo de los sensores y se determina y se desea guardar
        
    }
    
    public void detener(){
        bandera = false;
    }
    
}
