/*
Separar la trama en tres valores double
 */
package com.app.controlador.muestreo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarTrama {

    public double[] hacer(String trama) {
        if (esValida(trama)) {
            //Si la trama es valida pasamos a descomponer en sus elementos A,B Y C
            String a = "", b = a, c = a;
            int i = 0;
            while (i < trama.length()) {
                switch (trama.charAt(i)) {
                    case 'a':
                        //Grabar a
                        i++;
                        while (isNumero(trama.charAt(i))) {
                            a += trama.charAt(i);
                            i++;
                        }
                        break;
                    case 'b':
                        //Grabar a
                        i++;
                        while (isNumero(trama.charAt(i))) {
                            b += trama.charAt(i);
                            i++;
                        }
                        break;
                    case 'c':
                        //Grabar a
                        i++;
                        while (i < trama.length()) {
                            c += trama.charAt(i);
                            i++;
                        }
                        break;
                    default:
                        break;
                }
            }
            return new double[]{Double.valueOf(a),Double.valueOf(b),Double.valueOf(c)};
        }
        else{
            return new double[]{0.0,0.0,0.0};
        }
    }

    private boolean esValida(String trama) {
        //La trama inicia con una 'a' seguido de un numero de 4 digitos
        //seguido de 'b' seguido de un numero de 4 digitos
        //seguido de 'c' seguido de un numero de 4 digitos
        Pattern pat = Pattern.compile("^a\\d{1,4}b\\d{1,4}c\\d{1,4}");
        Matcher mat = pat.matcher(trama);
        return mat.matches();
    }

    private boolean isNumero(char c) {
        return c >= 48 && c <= 57;
    }
}
