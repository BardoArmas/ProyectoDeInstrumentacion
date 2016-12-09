/*
Esta clase analisa las tramas de entrada por el puerto para verficicar si son correctas
 */
package com.app.controlador.analisis;

import com.app.vista.igusuario.Analizando;

public class AnalizarTramas {
    
    public void espera(){
        new Analizando().setVisible(true);
    }
}
