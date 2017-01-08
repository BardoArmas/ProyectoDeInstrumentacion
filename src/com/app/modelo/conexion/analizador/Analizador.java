/*
Analizador de tramas para validar flujo de cadenas entrantes
 */
package com.app.modelo.conexion.analizador;

import com.app.modelo.entidades.Trama;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizador {

    private final String EXPRESION_REGULAR = "^a1?\\d{1,3}b1?\\d{1,3}c1?\\d{1,3}";
    
    public Trama convertir(String linea){
        if(!isTrama(linea)){
            return new Trama(-1, -1, -1);
        }
        return seccionar(linea);
    }

    private boolean isTrama(String linea) {
        Pattern pat = Pattern.compile(EXPRESION_REGULAR);
        Matcher mat = pat.matcher(linea);
        return mat.matches();
    }

    private Trama seccionar(String linea) {
        Trama trama = new Trama();
        String a = "", b = a, c = a;
        int i = 0;
        while (i < linea.length()) {
            switch (linea.charAt(i)) {
                case 'a':
                    //Grabar a
                    i++;
                    while (isNumero(linea.charAt(i))) {
                        a += linea.charAt(i);
                        i++;
                    }
                    break;
                case 'b':
                    //Grabar a
                    i++;
                    while (isNumero(linea.charAt(i))) {
                        b += linea.charAt(i);
                        i++;
                    }
                    break;
                case 'c':
                    //Grabar a
                    i++;
                    while (i < linea.length()) {
                        c += linea.charAt(i);
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        trama.setA(Integer.valueOf(a));
        trama.setB(Integer.valueOf(b));
        trama.setC(Integer.valueOf(c));
        return trama;
    }

    private boolean isNumero(char c) {
        return c >= 48 && c <= 57;
    }
    
    public static void main(String[] args) {
        String t = "a709b801c1654";
        String t2 = "a1344b801c281";
        String t3 = "a344b8012cg281";
        String t4 = "a0b0c0";
        Analizador a = new Analizador();
        System.out.println(a.convertir(t));
        System.out.println(a.convertir(t2));
        System.out.println(a.convertir(t3));
        System.out.println(a.convertir(t4));
    }
}
