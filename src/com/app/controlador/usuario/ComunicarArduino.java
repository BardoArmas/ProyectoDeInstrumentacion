package com.app.controlador.usuario;

import com.app.controlador.sesion.Sesion;
import com.app.vista.ig.Muestreo;
import com.app.vista.ig.Principal;
import javax.swing.JOptionPane;

public class ComunicarArduino {

    public static void hacer(Sesion sesion, Principal principal) {
        if (sesion.getArduino().comunicarRXTX(sesion.getParametros())) {
            //Se comunico con exito al arduino
            new Muestreo(sesion, principal).setVisible(true);
            principal.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(principal, "Error al comunicar con arduino", "Error en arduino", JOptionPane.ERROR_MESSAGE);
        }
    }
}
