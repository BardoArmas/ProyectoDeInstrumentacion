/*
Guardar los resultados
 */
package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.entidades.Muestra;
import com.app.modelo.entidades.Usuario;

public class GuardarMuestrasPorUsuario {
    
    public void get(Sesion sesion, Muestra muestra){
        try{
            Usuario usuario = sesion.getUsuario();
            //Guardar los datos adquiridos por arduino
            
        }
        catch(NullPointerException e){
            System.err.println("Error al sacar el usuario de la sesion o muestras " + e);
        }
    }
}
